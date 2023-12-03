package interface_adapter.todo_panel;

import use_case.todo_panel.ToDoPanelInputBoundary;
import use_case.todo_panel.ToDoPanelInputData;

public class ToDoPanelController {
    private final ToDoPanelInputBoundary toDoPanelInteractor;

    public ToDoPanelController(ToDoPanelInputBoundary toDoPanelInteractor) {
        this.toDoPanelInteractor = toDoPanelInteractor;
    }

    public void initializeToDoPanel(long projectID, long toDoPanelID) {
        ToDoPanelInputData toDoPanelInputData = new ToDoPanelInputData(projectID, toDoPanelID);
        toDoPanelInteractor.importToDoList(toDoPanelInputData);
    }
}
