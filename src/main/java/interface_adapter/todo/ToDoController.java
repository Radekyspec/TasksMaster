package interface_adapter.todo;

import use_case.todo.ToDoInputBoundary;

public class ToDoController {
    private final ToDoInputBoundary toDoInteractor;

    public ToDoController(ToDoInputBoundary toDoInteractor) {
        this.toDoInteractor = toDoInteractor;
    }
}
