package data_access.project.add;

import entities.project.Project;
import entities.user.User;

public interface AddProjectUserDataAccessInterface {
    Project createProject(User user, String name, String description);
}
