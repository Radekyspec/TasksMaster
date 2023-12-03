package data_access.todopanel;

import entities.todo_list.ToDoList;
import entities.todo_panel.ToDoPanel;

import java.util.List;

public interface ToDoPanelDataAccessInterface {
    /**
     * Get lists from api.
     * @param projectID namely.
     * @param toDoPanelID namely.
     * @return A list of ToDoList.
     */
    List<ToDoList> importToDoList(Integer projectID, Integer toDoPanelID);

    /**
     * namely
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
