package use_case.todo.add;

public class AddToDoInputData {
    private final String target;
    private final String progress;
    private final long listID;
    private final String[] assignedTo;
    private final long toDoID;

    public String getTarget() {
        return target;
    }

    public String getProgress() {
        return progress;
    }

    public long getListID() {
        return listID;
    }

    public String[] getAssignedTo() {
        return assignedTo;
    }

    public long getToDoID() {
        return toDoID;
    }

    public AddToDoInputData(String target, String progress, long listID, String[] assignedTo, long toDoID) {
        this.target = target;
        this.progress = progress;
        this.listID = listID;
        this.assignedTo = assignedTo;
        this.toDoID = toDoID;
    }
}
