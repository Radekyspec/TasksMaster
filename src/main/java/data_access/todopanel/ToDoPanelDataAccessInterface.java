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
     * 判断其成果取决于是否返回null。
     * 返回null就是失败
     * 返回空列表代表东西是空的。
     * @return
     */
    ToDoPanel getToDoPanel();
}
