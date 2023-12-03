package data_access.todo.add;

import entities.todo.ToDo;

public interface AddToDoUserDataAccessInterface {
    /**
     * Create a new to_do List. Add data passed in.
     * Data should come from an Interactor.
     *
     * @param toDoID     receive toDoID
     * @param listID     receive listID
     * @param target     receive target
     * @param assignedTo receive assignedTo
     * @param progress   receive progress
     * @return a finished, non-empty ToDoList.
     */
    ToDo createToDo(Integer toDoID, Integer listID, String target, String[] assignedTo, String progress);
    /**
     * namely
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
