package interface_adapter.todo.add_todo;

import entities.todo.ToDo;

public class AddToDoState {
    private long toDoListID;
    private long projectID;
    private String target;
    private String progress;
    private String ATDSError;
    private ToDo newCreatedToDo;

    public ToDo getNewCreatedToDo() {
        return newCreatedToDo;
    }

    public void setNewCreatedToDo(ToDo newCreatedToDo) {
        this.newCreatedToDo = newCreatedToDo;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public long getToDoListID() {
        return toDoListID;
    }

    public void setToDoListID(long toDoID) {
        this.toDoListID = toDoID;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getATDSError() {
        return ATDSError;
    }

    public void setATDSError(String ATDSError) {
        this.ATDSError = ATDSError;
    }

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }
}
