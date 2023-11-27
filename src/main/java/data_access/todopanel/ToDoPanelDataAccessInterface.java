package data_access.todopanel;

import entities.todo_panel.ToDoPanel;

public interface ToDoPanelDataAccessInterface {
    /**
     * Save the provided ToDoPanel to the DB.
     * when implementing, it will call method save() to persist the changes.
     * @param toDoPanel the organized entity that is going to store.
     */
    void save(ToDoPanel toDoPanel);

    /**
     * Verify if this ToDoPanel is already exists.
     * @param tdpName the name of the ToDoPanel
     * @return ture or false
     */
    boolean exists(String tdpName);
}
