package interface_adapter.todo.add_todo;

import entities.todo.ToDo;

public class AddToDoState {
    private Integer toDoID;
    private String target;
    private String[] assignTo;
    private String progress;
    private String ATDSError;
    private ToDo newCreatedToDo;

    public ToDo getNewCreatedToDo() {
        return newCreatedToDo;
    }

    public void setNewCreatedToDo(ToDo newCreatedToDo) {
        this.newCreatedToDo = newCreatedToDo;
    }

    public AddToDoState() {
        toDoID = null;
        target = null;
        assignTo = null;
        progress = null;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Integer getToDoID() {
        return toDoID;
    }

    public void setToDoID(Integer toDoID) {
        this.toDoID = toDoID;
    }

    public String getTarget() {
        return target;
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

    public String getATDSError() {
        return ATDSError;
    }

    public void setATDSError(String ATDSError) {
        this.ATDSError = ATDSError;
    }


}
