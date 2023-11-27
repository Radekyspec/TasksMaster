package entities.todo_panel;

import entities.todo_list.ToDoList;

import java.util.Map;

public interface ToDoPanel {
    /**
     * Returns ID of this obj.
     *
     * @return its ID.
     */
    Integer getId();

    /**
     * Returns lists of this obj.
     *
     * @return all the TO_DOList managed by this panel.
     */
    Map<Integer, ToDoList> getLists();
}
