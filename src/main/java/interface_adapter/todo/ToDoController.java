package interface_adapter.todo;

import entities.todo.ToDo;
import use_case.todo.ToDoInputBoundary;
import use_case.todo.ToDoInputData;

import java.util.Map;

public class ToDoController {
    private final ToDoInputBoundary toDoInteractor;

    public ToDoController(ToDoInputBoundary toDoInteractor) {
        this.toDoInteractor = toDoInteractor;
    }

    public void doImportToDo(Map<Integer, ToDo> toDoPackage) {
        ToDoInputData toDoInputData = new ToDoInputData("import",
                null, null, null, null, toDoPackage);
        toDoInteractor.execute(toDoInputData);
    }

    public void doCreateToDos(String workKind,
                                  String ID, String name, String[] assignedTo) {
        ToDoInputData toDoInputData = new ToDoInputData("create", ID, name,
                assignedTo, "incomplete", null);
        toDoInteractor.execute(toDoInputData);
    }
}
