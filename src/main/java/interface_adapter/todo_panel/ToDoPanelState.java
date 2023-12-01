package interface_adapter.todo_panel;

import entities.todo_list.ToDoList;
import entities.todo_panel.ToDoPanel;

import java.util.HashMap;
import java.util.Map;

public class ToDoPanelState {
    private ToDoPanel currentToDoPanel;
    private String toDoPanelError;
    private String workKind;

    public ToDoPanelState() {
        currentToDoPanel = null;
        toDoPanelError = null;
        workKind = null;
    }

    public String getToDoPanelError() {
        return toDoPanelError;
    }

    public void setToDoPanelError(String toDoPanelError) {
        this.toDoPanelError = toDoPanelError;
    }

    public ToDoPanel getCurrentToDoPanel() {
        return currentToDoPanel;
    }

    public void setCurrentToDoPanel(ToDoPanel currentToDoPanel) {
        this.currentToDoPanel = currentToDoPanel;
    }

    public String getWorkKind() {
        return workKind;
    }

    public void setWorkKind(String workKind) {
        this.workKind = workKind;
    }

}
