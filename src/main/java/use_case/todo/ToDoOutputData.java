package use_case.todo;

import entities.todo.ToDo;

import java.util.Map;

public class ToDoOutputData {
    private final String error;
    private final boolean useCaseFailed;
    private final Map<Integer, ToDo> toDoPackage;
    private final String target;
    private final String[] assignTo;
    private final String progress;
    private final String workKind;

    public ToDoOutputData(String workKind,
                          String error, boolean useCaseFailed,
                          String target, String[] assignTo, String progress,
                          Map<Integer, ToDo> toDoPackage) {
        this.error = error;
        this.useCaseFailed = useCaseFailed;
        this.toDoPackage = toDoPackage;
        this.target = target;
        this.assignTo = assignTo;
        this.progress = progress;
        this.workKind = workKind;
    }

    public String getError() {
        return error;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public Map<Integer, ToDo> getToDoPackage() {
        return toDoPackage;
    }

    public String getTarget() {
        return target;
    }

    public String[] getAssignTo() {
        return assignTo;
    }

    public String getProgress() {
        return progress;
    }

    public String getWorkKind() {
        return workKind;
    }
}
