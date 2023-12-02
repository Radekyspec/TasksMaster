package interface_adapter.todo_list.add;

import use_case.todo_list.add.AddToDoListInputBoundary;
import use_case.todo_list.add.AddToDoListInputData;

public class AddToDoListController {
    private final AddToDoListInputBoundary interactor;

    public AddToDoListController(AddToDoListInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void mainLogic(String name, String detail, Integer ID) {
        interactor.execute(new AddToDoListInputData(name, detail, ID));
    }
}
