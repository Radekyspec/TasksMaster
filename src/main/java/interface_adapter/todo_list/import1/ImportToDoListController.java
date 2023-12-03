package interface_adapter.todo_list.import1;

import use_case.todo_list.import1.ImportToDoListInputBoundary;
import use_case.todo_list.import1.ImportToDoListInputData;

public class ImportToDoListController {
    private final ImportToDoListInputBoundary importToDoPanelInteractor;

    public ImportToDoListController(ImportToDoListInputBoundary importToDoPanelInteractor) {
        this.importToDoPanelInteractor = importToDoPanelInteractor;
    }

    public void importToDoLists(long projectID, long toDoPanelID) {
        ImportToDoListInputData importToDoListInputData = new ImportToDoListInputData(projectID, toDoPanelID);
        importToDoPanelInteractor.importToDoList(importToDoListInputData);
    }
}
