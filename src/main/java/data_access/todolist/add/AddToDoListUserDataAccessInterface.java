package data_access.todolist.add;

import entities.todo_list.ToDoList;

public interface AddToDoListUserDataAccessInterface {
    /**
     * Create a new to_do List. Add data passed in.
     *  Data should come from an Interactor.
     * @param projectID receive projectID
     * @param toDoPanelID receive listID
     * @param name receive name
     * @param detail receive detail
     * @return a finished, non-empty ToDoList.
     */
    ToDoList createToDoList(long projectID, long toDoPanelID, String name, String detail);

    /**
     * namely
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
