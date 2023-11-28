package use_case.project.choose;

import entities.user.User;

public class ChooseProjectInputData {
    private int projectId;
    private User user;

    public ChooseProjectInputData(int projectId) {
        this.projectId = projectId;
    }

    public ChooseProjectInputData(User user) {
        this.user = user;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
