package interface_adapter.todo_list;

import use_case.todo_list.ToDoListInputBoundary;
import use_case.todo_panel.ToDoPanelInputData;
import use_case.todo_panel.ToDoPanelInteractor;

public class ToDoListController {
    private final ToDoListInputBoundary toDoListInteractor;

    public ToDoListController(ToDoListInputBoundary toDoListInteractor) {
        this.toDoListInteractor = toDoListInteractor;
    }

    public void execute(String ID, String ProjectID) {
        ToDoPanelInputData toDoPanelInputData = new ToDoPanelInputData(ID, ProjectID);
        ToDoPanelInteractor.execute(toDoPanelInputData);
    }
}
