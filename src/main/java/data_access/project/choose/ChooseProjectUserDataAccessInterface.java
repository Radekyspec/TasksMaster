package data_access.project.choose;

import entities.project.Project;
import entities.user.User;

import java.util.List;

public interface ChooseProjectUserDataAccessInterface {
    List<Project> getUserProjects(User user);
}
