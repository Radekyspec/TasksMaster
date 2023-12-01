package use_case.project.choose;

import entities.project.Project;
import entities.user.User;

public class ChooseProjectInputData {
    private final Project project;
    private final User user;

    public ChooseProjectInputData(Project project) {
        this.project = project;

        user = null;
    }

    public ChooseProjectInputData(User user) {
        this.user = user;

        project = null;
    }

    public Project getProject() {
        return project;
    }

    public User getUser() {
        return user;
    }
}
