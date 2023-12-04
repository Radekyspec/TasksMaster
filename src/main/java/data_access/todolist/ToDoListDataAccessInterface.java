package data_access.todolist;

import entities.todo.ToDo;

import java.util.List;

public interface ToDoListDataAccessInterface {
    /**
     * Get to_dos from api.
     *
     * @param projectID  namely.
     * @param toDoListID namely.
     * @return A list of To_Do.
     */
    List<ToDo> importToDo(long projectID, long toDoListID);

    /**
     * namely
     *
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
