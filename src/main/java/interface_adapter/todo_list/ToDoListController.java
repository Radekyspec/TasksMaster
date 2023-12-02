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
                0, 0); // TODO: get to know what did the projectID and toDoListID comes.
        toDoListInteractor.execute(toDoListInputData);
    }
}
