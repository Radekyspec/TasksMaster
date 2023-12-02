package use_case.todo_list;

import entities.todo_list.ToDoList;

import java.util.Map;

public class ToDoListInputData {
    private final Integer projectID;
    private final Integer toDoListID;

    /**
     * Initialize a standard ToDoListInputData.
     * InputData only pass projectID and toDoListID here,
     * as it only in charges of importing ToDos.
     *
     * @param projectID  the project id those todos belongs to.
     * @param toDoListID the ToDoList id those todos belongs to.
     */
    public ToDoListInputData(Integer projectID, Integer toDoListID) {
        this.projectID = projectID;
        this.toDoListID = toDoListID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public Integer getToDoListID() {
        return toDoListID;
    }
}
