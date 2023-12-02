package interface_adapter.project.add_people;

import entities.project.Project;

public class AddPeopleState {
    private String username;
    private Project project;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
