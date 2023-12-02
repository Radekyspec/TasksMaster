package interface_adapter.todo_panel;

import use_case.todo_panel.ToDoPanelInputData;
import use_case.todo_panel.ToDoPanelInputBoundary;

public class ToDoPanelController {
    private final ToDoPanelInputBoundary toDoPanelInteractor;

    public ToDoPanelController(ToDoPanelInputBoundary toDoPanelInteractor) {
        this.toDoPanelInteractor = toDoPanelInteractor;
    }

    public void initializeToDoPanel(Integer projectID) {
        ToDoPanelInputData toDoPanelInputData = new ToDoPanelInputData(projectID);
        toDoPanelInteractor.importToDoList(toDoPanelInputData);
    }
    
}
