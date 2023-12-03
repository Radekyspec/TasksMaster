package data_access.todo.add;

import entities.todo.ToDo;

public interface AddToDoUserDataAccessInterface {
    /**
     * Create a new to_do List. Add data passed in.
     * Data should come from an Interactor.
     *
     * @param projectID     receive toDoID
     * @param listID     receive listID
     * @param target     receive target
     * @param progress   receive progress
     * @return a finished, non-empty ToDoList.
     */
    ToDo createToDo(long projectID, long listID, String target, String progress);
    /**
     * namely
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
