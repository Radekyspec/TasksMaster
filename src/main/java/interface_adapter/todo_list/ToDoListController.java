package interface_adapter.todo_list;

import use_case.todo_list.ToDoListInputBoundary;
import use_case.todo_list.ToDoListInputData;

public class ToDoListController {
    private final ToDoListInputBoundary toDoListInteractor;

    public ToDoListController(ToDoListInputBoundary toDoListInteractor) {
        this.toDoListInteractor = toDoListInteractor;
    }

    public void execute() {
        ToDoListInputData toDoListInputData = new ToDoListInputData(
                0, 0); // TODO: get to know how to import projectID and toDoListID.
        toDoListInteractor.execute(toDoListInputData);
    }
}
