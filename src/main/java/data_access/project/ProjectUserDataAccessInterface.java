package data_access.project;

import entities.project.Project;

import java.util.List;

public interface ProjectUserDataAccessInterface {
    List<Project> getAllProjects();
    boolean addProjectMember(Project project, String username);
    String getApiErrorMessage();

    boolean exists(String username, Project project);
}
