package data_access.todolist.add;

import entities.project.Project;
import entities.todo_list.ToDoList;

public interface AddToDoListUserDataAccessInterface {
    /**
     * Create a new to_do List. Add data passed in.
     *  Data should come from an Interactor.
     * @param projectID receive projectID
     * @param ID receive ID
     * @param name receive name
     * @param detail receive detail
     * @return a finished, non-empty ToDoList.
     */
    ToDoList createToDoList(Integer projectID, Integer ID, String name, String detail);

    /**
     * namely
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
