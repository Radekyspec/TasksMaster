package interface_adapter.todo_list;

import use_case.todo_list.ToDoListInputBoundary;
import use_case.todo_list.ToDoListInputData;

public class ToDoListController {
    private final ToDoListInputBoundary toDoListInteractor;

    public ToDoListController(ToDoListInputBoundary toDoListInteractor) {
        this.toDoListInteractor = toDoListInteractor;
    }

    public void execute(long projectID, long toDoListID) {
        ToDoListInputData toDoListInputData = new ToDoListInputData(
                projectID, toDoListID);
        toDoListInteractor.execute(toDoListInputData);
    }
}
