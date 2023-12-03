package data_access.todopanel;

import entities.todo_list.ToDoList;

import java.util.List;

public interface ToDoPanelDataAccessInterface {
    /**
     * Get lists from api.
     * @param projectID namely.
     * @param toDoPanelID namely.
     * @return A list of ToDoList.
     */
    List<ToDoList> importToDoList(long projectID, long toDoPanelID);

    /**
     * namely
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
