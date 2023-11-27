package interface_adapter.todo_panel;

import entities.todo_list.ToDoList;

import java.util.HashMap;
import java.util.Map;

public class ToDoPanelState {
    private final Map<Integer, ToDoList> toDoLists;
    private String toDoPanelError;

    public ToDoPanelState() {
        toDoLists = new HashMap<>();
        toDoPanelError = null;
    }

    public String getToDoPanelError() {
        return toDoPanelError;
    }

    public void setToDoPanelError(String toDoPanelError) {
        this.toDoPanelError = toDoPanelError;
    }

    public Map<Integer, ToDoList> getToDoLists() {
        return toDoLists;
    }
}
