package use_case.todo;

import entities.todo.ToDo;

import java.util.Map;

public class ToDoInputData {
    private final String workKind;
    private final String ID;
    private final String target;
    private final String[] assignedTo;
    private final Map<Long, ToDo> toDoPackage;
    private final String progress;

    public ToDoInputData(String workKind,
                         String ID, String target,
                         String[] assignedTo,
                         String progress,
                         Map<Long, ToDo> toDoPackage) {

        this.workKind = workKind;
        this.ID = ID;
        this.target = target;
        this.assignedTo = assignedTo;
        this.progress = progress;
        this.toDoPackage = toDoPackage;
    }
    /**
     * Namely
     * @return workKind
     */
    public String getWorkKind() {
        return workKind;
    }

    /**
     * Namely
     * @return ID, only for "create"
     */
    public String getID() {
        return ID;
    }

    /**
     * Namely
     * @return target, only for "create"
     */
    public String getTarget() {
        return target;
    }

    /**
     * Namely
     * @return AssignedTo, only for "create"
     */
    public String[] getAssignedTo() {
        return assignedTo;
    }

    /**
     * Namely
     * @return a map of To_Do, only for "import"
     */
    public Map<Long, ToDo> getToDoPackage() {
        return toDoPackage;
    }

    /**
     * Namely
     * @return isFinished of To_Do, only for "create"
     */
    public String getProgress() {
        return progress;
    }
}
