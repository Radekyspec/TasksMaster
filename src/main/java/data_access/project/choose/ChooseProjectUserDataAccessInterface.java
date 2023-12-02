package data_access.project.choose;

import entities.project.Project;
import entities.todo_list.ToDoList;
import entities.user.User;

import java.util.List;

public interface ChooseProjectUserDataAccessInterface {
    List<Project> getUserProjects(User user);

    String getApiErrorMessage();
}
