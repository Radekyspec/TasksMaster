package interface_adapter.todo_list;

import entities.todo_list.ToDoList;
import use_case.todo_list.ToDoListInputBoundary;
import use_case.todo_list.ToDoListInputData;

import java.util.Map;

public class ToDoListController {
    private final ToDoListInputBoundary toDoListInteractor;

    public ToDoListController(ToDoListInputBoundary toDoListInteractor) {
        this.toDoListInteractor = toDoListInteractor;
    }

    public void doImportToDoList(Map<Integer, ToDoList> toDoListPackage) {
        ToDoListInputData toDoListInputData = new ToDoListInputData("import",
                null, null, null, toDoListPackage);
        toDoListInteractor.execute(toDoListInputData);
    }

    public void doCreateToDoLists(String workKind,
                                  String ID, String name, String detail) {
        ToDoListInputData toDoListInputData = new ToDoListInputData("create", ID, name,
                detail, null);
        toDoListInteractor.execute(toDoListInputData);
    }
}
