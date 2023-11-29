package data_access.project;

import entities.project.Project;
import entities.user.User;

import java.util.List;

public interface ProjectUserDataAccessInterface {
    List<Project> getAllProjects();
    boolean addProjectMember(Project project, User user);
}
