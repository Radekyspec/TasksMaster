package interface_adapter.todo_panel;

import use_case.todo_panel.ToDoPanelInputBoundary;
import use_case.todo_panel.ToDoPanelInputData;
import use_case.todo_panel.ToDoPanelInteractor;

public class ToDoPanelController {
    private final ToDoPanelInputBoundary toDoPanelInteractor;


    public ToDoPanelController(ToDoPanelInputBoundary toDoPanelInteractor) {
        this.toDoPanelInteractor = toDoPanelInteractor;
    }


    public void execute(String ID, String ProjectID) {
        ToDoPanelInputData toDoPanelInputData = new ToDoPanelInputData(ID, ProjectID);
        ToDoPanelInteractor.execute(toDoPanelInputData);
    }
}
