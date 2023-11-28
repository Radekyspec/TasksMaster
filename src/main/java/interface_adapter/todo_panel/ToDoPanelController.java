package interface_adapter.todo_panel;

import use_case.todo_panel.ToDoPanelInputBoundary;
import use_case.todo_panel.ToDoPanelInputData;
import use_case.todo_panel.ToDoPanelInteractor;

public class ToDoPanelController {
    private final ToDoPanelInputBoundary toDoPanelInteractor;


    public ToDoPanelController(ToDoPanelInputBoundary toDoPanelInteractor) {
        this.toDoPanelInteractor = toDoPanelInteractor;
    }


    // TODO 对于有两个逻辑的方法，应当写两个方法，或者写两套的逻辑，使用例如statename进行判断。
    public void execute(String ID, String ProjectID) {
        ToDoPanelInputData toDoPanelInputData = new ToDoPanelInputData(ID, ProjectID);
        ToDoPanelInteractor.execute(toDoPanelInputData);
    }
}
