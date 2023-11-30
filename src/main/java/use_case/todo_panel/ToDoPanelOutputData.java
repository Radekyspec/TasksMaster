package use_case.todo_panel;

import entities.todo_panel.ToDoPanel;

public class ToDoPanelOutputData {
    private final String workKind;
    private final String error;
    private final boolean useCaseFailed;
    private final ToDoPanel toDoPanel;
    public ToDoPanelOutputData(String workKind, String error, ToDoPanel toDoPanel, boolean useCaseFailed) {
        this.workKind = workKind;
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
    public String getWorkKind() {
        return workKind;
    }
}
