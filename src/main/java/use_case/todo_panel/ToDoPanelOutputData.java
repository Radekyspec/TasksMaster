package use_case.todo_panel;

import entities.todo_panel.ToDoPanel;

public class ToDoPanelOutputData {
    private final String error;
    private final boolean useCaseFailed;
    private final ToDoPanel toDoPanel;
    public ToDoPanelOutputData(String error, ToDoPanel toDoPanel, boolean useCaseFailed) {
        this.error = error;
        this.toDoPanel = toDoPanel;
        this.useCaseFailed = useCaseFailed;
    }
    public String getError() {
        return error;
    }
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
