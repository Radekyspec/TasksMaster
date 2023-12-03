package interface_adapter.todo.add_todo;


import use_case.todo.add.AddToDoInputBoundary;
import use_case.todo.add.AddToDoInputData;

public class AddToDoController {
    private final AddToDoInputBoundary addToDoInteractor;

    public AddToDoController(AddToDoInputBoundary addToDoInteractor) {
        this.addToDoInteractor = addToDoInteractor;
    }

    public void addMainLogic(String target, String progress, long toDoListID, long projectID) {
        AddToDoInputData addToDoInputData = new AddToDoInputData(target, progress, toDoListID, projectID);
        addToDoInteractor.importAddToDoList(addToDoInputData);
    }
}
