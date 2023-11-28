package data_access;

import data_access.login.LoginUserDataAccessInterface;
import data_access.project.ProjectUserDataAccessInterface;
import data_access.project.add.AddProjectUserDataAccessInterface;
import data_access.project.choose.ChooseProjectUserDataAccessInterface;
import data_access.signup.SignupUserDataAccessInterface;
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
import java.util.List;
import java.util.Map;

public abstract class HttpDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface, ProjectUserDataAccessInterface, ChooseProjectUserDataAccessInterface,
        AddProjectUserDataAccessInterface {
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
        if (isValidApiKey()) {
            return null;
        }
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
        project.setLeader(getAllUsers().get(projectInfo.getString("owner")));
        JSONArray members = projectInfo.getJSONArray("members");
        for (int i = 0; i < members.length(); i++) {
            project.addNewMember(getAllUsers().get(members.getString(i)));
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
            if (project.getMembers().containsKey(user.getName())) {
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
    public boolean addProjectMember(Project project, User user) {
        project.addNewMember(user);
        JSONObject projectInfo = new JSONObject();
        projectInfo.put("owner", project.getLeader());
        JSONArray members = new JSONArray();
        members.putAll(project.getMembers().values());
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

        try {
            Response response = client.newCall(request).execute();
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
}
