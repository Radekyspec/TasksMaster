package use_case.todo_list;

public class ToDoListInputData {
    private final long projectID;
    private final long toDoListID;

    /**
     * Initialize a standard ToDoListInputData.
     * InputData only pass projectID and toDoListID here,
     * as it only in charges of importing ToDos.
     *
     * @param projectID  the project id those todos belongs to.
     * @param toDoListID the ToDoList id those todos belongs to.
     */
    public ToDoListInputData(long projectID, long toDoListID) {
        this.projectID = projectID;
        this.toDoListID = toDoListID;
    }

    public long getProjectID() {
        return projectID;
    }

    public long getToDoListID() {
        return toDoListID;
    }
}
