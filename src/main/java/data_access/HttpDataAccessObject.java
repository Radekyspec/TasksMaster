package data_access;

import data_access.login.LoginUserDataAccessInterface;
import data_access.message_board.MessageBoardUserDataAccessInterface;
import data_access.project.ProjectUserDataAccessInterface;
import data_access.project.add.AddProjectUserDataAccessInterface;
import data_access.project.choose.ChooseProjectUserDataAccessInterface;
import data_access.signup.SignupUserDataAccessInterface;
import entities.comment.Comment;
import entities.comment.CommonCommentFactory;
import entities.message.CommonMessageFactory;
import entities.message.Message;
import entities.message_board.CommonMessageBoardFactory;
import entities.project.CommonProjectFactory;
import entities.project.Project;
import entities.schedule.CommonScheduleFactory;
import entities.todo_panel.CommonToDoPanelFactory;
import entities.user.User;
import exceptions.InvalidApiKeyException;

import okhttp3.*;
import org.json.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class HttpDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, ProjectUserDataAccessInterface, ChooseProjectUserDataAccessInterface,
        AddProjectUserDataAccessInterface, MessageBoardUserDataAccessInterface {
    private final String API_KEY;
    private int orgId;
    private String error;
    private final OkHttpClient client = new OkHttpClient().newBuilder()
            .build();

    public HttpDataAccessObject(String apiKey) throws InvalidApiKeyException {
        API_KEY = apiKey;
        if (!isValidApiKey()) {
            throw new InvalidApiKeyException(getApiErrorMessage());
        }
    }

    private Request.Builder buildRequest() {
        return new Request.Builder()
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("User-Agent", "TasksMaster (w41k3r15347@gmail.com)");
    }

    private boolean isValidApiKey() {
        if (API_KEY == null || API_KEY.isEmpty() || API_KEY.isBlank()) {
            return false;
        }
        Request request = buildRequest()
                .url("https://launchpad.37signals.com/authorization.json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Network Error");
                return false;
            }
            JSONObject lastResponse = new JSONObject(response.body().string());
            if (!lastResponse.has("error")) {
                orgId = lastResponse.getJSONArray("accounts").getJSONObject(0).getInt("id");
                return true;
            }
            setErrorMessage(lastResponse.getString("error"));
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return false;
        }

        return false;
    }

    public String getApiErrorMessage() {
        if (API_KEY == null || API_KEY.isEmpty() || API_KEY.isBlank()) {
            return "API key is empty.";
        }
        return error;
    }

    private void setErrorMessage(String message) {
        this.error = message;
    }

    private Project jsonToProject(JSONObject projectJson) {
        JSONObject projectInfo = new JSONObject(projectJson.getString("description"));
        Project project = CommonProjectFactory.create(projectJson.getInt("id"),
                projectJson.getString("name"),
                projectInfo.getString("description"));
        project.setLeader(projectInfo.getString("owner"));
        JSONArray members = projectInfo.getJSONArray("members");
        for (int i = 0; i < members.length(); i++) {
            project.addNewMember(members.getString(i));
        }
        JSONArray docks = projectJson.getJSONArray("dock");
        int toDoPanelId = 0, messageBoardId = 0, scheduleId = 0;
        for (int j = 0; j < docks.length(); j++) {
            JSONObject dock = docks.getJSONObject(j);
            switch (dock.getString("name")) {
                case "message_board" -> messageBoardId = dock.getInt("id");
                case "todoset" -> toDoPanelId = dock.getInt("id");
                case "schedule" -> scheduleId = dock.getInt("id");
            }
        }
        project.setToDoPanel(CommonToDoPanelFactory.create(toDoPanelId));
        project.setMessageBoard(CommonMessageBoardFactory.create(messageBoardId));
        project.setSchedule(CommonScheduleFactory.create(scheduleId));
        return project;
    }

    protected abstract Map<String, User> getAllUsers();

    @Override
    public List<Project> getAllProjects() {
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/projects.json", orgId))
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONArray responseJson = new JSONArray(response.body().string());
            List<Project> projects = new ArrayList<>();
            for (int i = 0; i < responseJson.length(); i++) {
                JSONObject projectJson = responseJson.getJSONObject(i);
                projects.add(jsonToProject(projectJson));
            }
            return projects;
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        }
    }

    @Override
    public List<Project> getUserProjects(User user) {
        List<Project> projects = new ArrayList<>();
        for (Project project : getAllProjects()) {
            if (project.getMembers().contains(user.getName())) {
                projects.add(project);
            }
        }
        return projects;
    }

    @Override
    public Project createProject(User user, String name, String description) {
        JSONObject projectInfo = new JSONObject();
        projectInfo.put("owner", user.getName());
        projectInfo.put("members", new JSONArray(new String[] {user.getName()}));
        projectInfo.put("description", description);
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("description", projectInfo.toString());
        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/projects.json", orgId))
                .method("POST", body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.code() != 201 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONObject responseJson = new JSONObject(response.body().string());
            return jsonToProject(responseJson);
        } catch (IOException | JSONException e) {
            setErrorMessage("Network Error");
            return null;
        }
    }

    @Override
    public boolean addProjectMember(Project project, String user) {
        project.addNewMember(user);
        JSONObject projectInfo = new JSONObject();
        projectInfo.put("owner", project.getLeader());
        JSONArray members = new JSONArray();
        members.putAll(project.getMembers());
        projectInfo.put("members", members);
        projectInfo.put("description", project.getDescription());
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", project.getName());
        requestBody.put("description", projectInfo.toString());
        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/projects/%d.json", orgId, project.getID()))
                .method("PUT", body)
                .build();

        try (Response response = client.newCall(request).execute()){
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Network Error");
                return false;
            }
            return true;
        } catch (IOException | JSONException e) {
            setErrorMessage("Network Error");
            return false;
        }
    }

    @Override
    public boolean exists(String username, Project project) {
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/projects/%d.json", orgId, project.getID()))
                .build();
        try (Response response = client.newCall(request).execute()){
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Network Error");
                return true;
            }
            Project projectJson = jsonToProject(new JSONObject(response.body().string()));
            return projectJson.getMembers().contains(username);
        } catch (IOException | JSONException e) {
            setErrorMessage("Network Error");
            return true;
        }
    }

    @Override
    public List<Message> getMessages(int projectID, int messageBoardID) {
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/message_boards/%d/messages.json",
                        orgId, projectID, messageBoardID))
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            List<Message> messages = new ArrayList<>();
            JSONArray responseJson = new JSONArray(response.body().string());
            for (int i = 0; i < responseJson.length(); i++) {
                JSONObject rawMessage = responseJson.getJSONObject(i);
                String author = rawMessage.getString("content").split(":")[0];
                String content = Arrays.stream(rawMessage.getString("content").split(":")).skip(1)
                        .collect(Collectors.joining(":"));
                messages.add(CommonMessageFactory.create(
                        rawMessage.getInt("id"),
                        author,
                        rawMessage.getString("title"),
                        content
                ));
            }
            return messages;
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        } catch (JSONException e) {
            setErrorMessage("JSON Decode Error");
            return null;
        }
    }

    @Override
    public List<Comment> getComments(int projectID, int messageID) {
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/recordings/%d/comments.json",
                        orgId, projectID, messageID))
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Request Error");
                return null;
            }
            List<Comment> comments = new ArrayList<>();
            JSONArray responseJson = new JSONArray(response.body().string());

            for (int i = 0; i < responseJson.length(); i++) {
                JSONObject contentJson = responseJson.getJSONObject(i);
                String author = contentJson.getString("content").split(":")[0];
                String content = Arrays.stream(
                        contentJson.getString("content").split(":")).skip(1)
                        .collect(Collectors.joining(":"));
                comments.add(CommonCommentFactory.create(
                        contentJson.getInt("id"),
                        author,
                        content
                ));
            }
            return comments;
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        } catch (JSONException e) {
            setErrorMessage("JSON decode error");
            return null;
        }
    }

    @Override
    public Comment addComment(int projectID, int messageID, User user, String newComment) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", newComment);
        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/recordings/%d/comments.json",
                        orgId, projectID, messageID))
                .method("POST", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 201 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONObject responseJson = new JSONObject(response.body().string());
            String rawContent = responseJson.getString("content");
            return CommonCommentFactory.create(
                    requestBody.getInt("id"),
                    rawContent.split(":")[0],
                    Arrays.stream(
                            rawContent.split(":")).skip(1)
                            .collect(Collectors.joining(":"))
            );
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        } catch (JSONException e) {
            setErrorMessage("JSON decode error");
            return null;
        }
    }

    @Override
    public Message addMessage(
            int projectID, int messageBoardID, User author, String messageTitle, String messageContent) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("subject", messageTitle);
        requestBody.put("content", author.getName() + ":" + messageContent);
        requestBody.put("status", "active");
        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/message_boards/%d/messages.json",
                        orgId, projectID, messageBoardID))
                .method("POST", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 201 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONObject responseJson = new JSONObject(response.body().string());
            return CommonMessageFactory.create(
                    responseJson.getInt("id"),
                    author.getName(),
                    messageTitle,
                    messageContent
            );
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        } catch (JSONException e) {
            setErrorMessage("JSON decode error");
            return null;
        }
    }
}
