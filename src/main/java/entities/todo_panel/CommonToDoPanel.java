package entities.todo_panel;

import entities.todo_list.ToDoList;

import java.util.HashMap;
import java.util.Map;

public class CommonToDoPanel implements ToDoPanel {
    private long ID;
    private Map<Long, ToDoList> lists;

    public CommonToDoPanel(long ID) {
        this.ID = ID;
        this.lists = new HashMap<>();
    }

    /**
     * Returns ID of this obj.
     *
     * @return its ID.
     */
    @Override
    public long getId() {
        return this.ID;
    }

    /**
     * Returns lists of this obj.
     *
     * @return all the TO_DOList managed by this panel.
     */
    @Override
    public Map<Long, ToDoList> getLists() {
        return this.lists;
    }
}
