package use_case.todo_panel;

import entities.todo_panel.ToDoPanel;

public class ToDoPanelOutputData {
    private final ToDoPanel toDoPanel;
    private final String error;
    private final boolean useCaseFailed;
    public ToDoPanelOutputData(String error, boolean useCaseFailed, ToDoPanel toDoPanel) {
        this.toDoPanel = toDoPanel;
        this.error = error;
        this.useCaseFailed = useCaseFailed;
    }
    public String getError() {
        return error;
    }
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public ToDoPanel getToDoPanel() {
        return toDoPanel;
    }
}
