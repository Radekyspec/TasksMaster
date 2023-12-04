package data_access;

import data_access.login.LoginUserDataAccessInterface;
import data_access.message_board.MessageBoardUserDataAccessInterface;
import data_access.project.ProjectUserDataAccessInterface;
import data_access.project.add.AddProjectUserDataAccessInterface;
import data_access.project.choose.ChooseProjectUserDataAccessInterface;
import data_access.schedule.ScheduleDataAccessInterface;
import data_access.signup.SignupUserDataAccessInterface;
import data_access.todo.add.AddToDoUserDataAccessInterface;
import data_access.todolist.ToDoListDataAccessInterface;
import data_access.todolist.add.AddToDoListUserDataAccessInterface;
import data_access.todopanel.ToDoPanelDataAccessInterface;
import entities.comment.Comment;
import entities.comment.CommonCommentFactory;
import entities.event.CommonEventFactory;
import entities.event.Event;
import entities.message.CommonMessageFactory;
import entities.message.Message;
import entities.message_board.CommonMessageBoardFactory;
import entities.project.CommonProjectFactory;
import entities.project.Project;
import entities.schedule.CommonScheduleFactory;
import entities.todo.CommonToDoFactory;
import entities.todo.ToDo;
import entities.todo_list.CommonToDoListFactory;
import entities.todo_list.ToDoList;
import entities.todo_panel.CommonToDoPanelFactory;
import entities.user.User;
import exceptions.InvalidApiKeyException;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public abstract class HttpDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, ProjectUserDataAccessInterface, ChooseProjectUserDataAccessInterface,
        AddProjectUserDataAccessInterface, MessageBoardUserDataAccessInterface,
        AddToDoUserDataAccessInterface, ToDoListDataAccessInterface, AddToDoListUserDataAccessInterface,
        ToDoPanelDataAccessInterface, ScheduleDataAccessInterface {
    private final String API_KEY;
    private long orgId;
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
                orgId = lastResponse.getJSONArray("accounts").getJSONObject(0).getLong("id");
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
        Project project = CommonProjectFactory.create(projectJson.getLong("id"),
                projectJson.getString("name"),
                projectInfo.getString("description"));
        project.setLeader(projectInfo.getString("owner"));
        JSONArray members = projectInfo.getJSONArray("members");
        for (int i = 0; i < members.length(); i++) {
            project.addNewMember(members.getString(i));
        }
        JSONArray docks = projectJson.getJSONArray("dock");
        long toDoPanelId = 0, messageBoardId = 0, scheduleId = 0;
        for (int j = 0; j < docks.length(); j++) {
            JSONObject dock = docks.getJSONObject(j);
            switch (dock.getString("name")) {
                case "message_board" -> messageBoardId = dock.getLong("id");
                case "todoset" -> toDoPanelId = dock.getLong("id");
                case "schedule" -> scheduleId = dock.getLong("id");
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
        projectInfo.put("members", new JSONArray(new String[]{user.getName()}));
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

        try (Response response = client.newCall(request).execute()) {
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
        try (Response response = client.newCall(request).execute()) {
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
    public List<Message> getMessages(long projectID, long messageBoardID) {
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
                        rawMessage.getLong("id"),
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
    public List<Comment> getComments(long projectID, long messageID) {
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
                        contentJson.getLong("id"),
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
    public Comment addComment(long projectID, long messageID, User user, String newComment) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", user.getName() + ":" + newComment);
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
                    responseJson.getLong("id"),
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
            long projectID, long messageBoardID, User author, String messageTitle, String messageContent) {
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
                    responseJson.getLong("id"),
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

    @Override
    public ToDo createToDo(long projectID, long listID, String target, String progress) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", target);
        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/todolists/%d/todos.json",
                        orgId, projectID, listID))
                .method("POST", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 201 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONObject responseJson = new JSONObject(response.body().string());
            return CommonToDoFactory.create(
                    responseJson.getLong("id"),
                    target,
                    new String[]{},
                    progress
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
    public List<ToDo> importToDo(long projectID, long toDoListID) {
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/todolists/%d/todos.json",
                        orgId, projectID, toDoListID))
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONArray responseArray = new JSONArray(response.body().string());
            List<ToDo> toDos = new ArrayList<>();
            for (int i = 0; i < responseArray.length(); i++) {
                JSONObject responseJson = responseArray.getJSONObject(i);
                toDos.add(
                        CommonToDoFactory.create(
                                responseJson.getLong("id"),
                                responseJson.getString("content"),
                                new String[]{},
                                "incomplete"
                        )
                );
            }
            return toDos;
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        } catch (JSONException e) {
            setErrorMessage("JSON decode error");
            return null;
        }
    }

    @Override
    public ToDoList createToDoList(long projectID, long toDoPanelID, String name, String detail) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("description", detail);
        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/todosets/%d/todolists.json",
                        orgId, projectID, toDoPanelID))
                .method("POST", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 201 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONObject responseJson = new JSONObject(response.body().string());
            return CommonToDoListFactory.create(
                    responseJson.getLong("id"),
                    projectID,
                    name,
                    detail
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
    public List<ToDoList> importToDoList(long projectID, long toDoPanelID) {
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/todosets/%d/todolists.json",
                        orgId, projectID, toDoPanelID))
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONArray responseArray = new JSONArray(response.body().string());
            List<ToDoList> toDoLists = new ArrayList<>();
            for (int i = 0; i < responseArray.length(); i++) {
                JSONObject responseJson = responseArray.getJSONObject(i);
                toDoLists.add(
                        CommonToDoListFactory.create(
                                responseJson.getLong("id"),
                                projectID,
                                responseJson.getString("title"),
                                responseJson.getString("description")
                        )
                );
            }
            return toDoLists;
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        } catch (JSONException e) {
            setErrorMessage("JSON decode error");
            return null;
        }
    }

    @Override
    public List<Event> getEvents(long projectId, long scheduleId) {
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/schedules/%d/entries.json",
                        orgId, projectId, scheduleId))
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != 200 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONArray responseArray = new JSONArray(response.body().string());
            List<Event> events = new ArrayList<>();
            for (int i = 0; i < responseArray.length(); i++) {
                JSONObject responseJson = responseArray.getJSONObject(i);
                events.add(
                        CommonEventFactory.create(
                                responseJson.getLong("id"),
                                responseJson.getString("title"),
                                responseJson.getString("description"),
                                new SimpleDateFormat("yyyy-MM-dd")
                                        .parse(responseJson.getString("starts_at").split("T")[0]),
                                new SimpleDateFormat("yyyy-MM-dd")
                                        .parse(responseJson.getString("ends_at").split("T")[0]),
                                responseJson.getBoolean("all_day")
                        )
                );
            }
            return events;
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        } catch (JSONException e) {
            setErrorMessage("JSON decode error");
            return null;
        } catch (ParseException e) {
            setErrorMessage("Parse Date Time error");
            return null;
        }
    }

    @Override
    public Event addEvents(
            long projectId, long scheduleId, String eventName,
            String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userWith) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("summary", eventName);
        requestBody.put("starts_at", new SimpleDateFormat("yyyy-MM-dd").format(startAt) + "T00:00:00Z");
        requestBody.put("ends_at", new SimpleDateFormat("yyyy-MM-dd").format(endAt) + "T00:00:00Z");
        requestBody.put("description", notes);
        requestBody.put("all_day", isAllDay);
        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );
        Request request = buildRequest()
                .url(String.format("https://3.basecampapi.com/%d/buckets/%d/schedules/%d/entries.json",
                        orgId, projectId, scheduleId))
                .method("POST", body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.code());
            if (response.code() != 201 || response.body() == null) {
                setErrorMessage("Network Error");
                return null;
            }
            JSONObject responseJson = new JSONObject(response.body().string());
            return CommonEventFactory.create(
                    responseJson.getLong("id"),
                    responseJson.getString("title"),
                    responseJson.getString("description"),
                    new SimpleDateFormat("yyyy-MM-dd")
                            .parse(responseJson.getString("starts_at").split("T")[0]),
                    new SimpleDateFormat("yyyy-MM-dd")
                            .parse(responseJson.getString("ends_at").split("T")[0]),
                    responseJson.getBoolean("all_day")
            );
        } catch (IOException e) {
            setErrorMessage("Network Error");
            return null;
        } catch (JSONException e) {
            setErrorMessage("JSON decode error");
            return null;
        } catch (ParseException e) {
            setErrorMessage("Date Time parse error");
            return null;
        }
    }
}
