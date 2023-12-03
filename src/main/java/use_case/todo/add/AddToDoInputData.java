package use_case.todo.add;

public class AddToDoInputData {
    private final String target;
    private final String progress;
    private final Integer listID;
    private final String[] assignedTo;
    private final Integer toDoID;

    public String getTarget() {
        return target;
    }

    public String getProgress() {
        return progress;
    }

    public Integer getListID() {
        return listID;
    }

    public String[] getAssignedTo() {
        return assignedTo;
    }

    public Integer getToDoID() {
        return toDoID;
    }

    public AddToDoInputData(String target, String progress, Integer listID, String[] assignedTo, Integer toDoID) {
        this.target = target;
        this.progress = progress;
        this.listID = listID;
        this.assignedTo = assignedTo;
        this.toDoID = toDoID;
    }
}
