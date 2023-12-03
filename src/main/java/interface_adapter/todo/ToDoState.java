package interface_adapter.todo;

import entities.todo.ToDo;

import java.util.Map;

public class ToDoState {
    private String[] assignTo;
    private String workKind;
    private String progress;
    private String target;
    private String toDoError;
    private Map<Long, ToDo> toDoPackage;

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public ToDoState() {
        toDoError = null;
        toDoPackage = null;
        target = null;
        assignTo = null;
        progress = null;
        workKind = null;
    }

    public String getToDoError() {
        return toDoError;
    }

    public void setToDoError(String toDoError) {
        this.toDoError = toDoError;
    }

    public Map<Long, ToDo> getToDoPackage() {
        return toDoPackage;
    }

    public String getProgress() {
        return progress;
    }

    public String getTarget() {
        return target;
    }

    public String getWorkKind() {
        return workKind;
    }

    public void setWorkKind(String workKind) {
        this.workKind = workKind;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String[] getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String[] assignTo) {
        this.assignTo = assignTo;
    }
}
