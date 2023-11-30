package interface_adapter.project.choose;

import entities.project.Project;
import entities.user.User;

public class ChooseProjectState {
    private Project project;
    private User user;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
