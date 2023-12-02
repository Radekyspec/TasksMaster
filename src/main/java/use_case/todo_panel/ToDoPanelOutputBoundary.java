package use_case.todo_panel;

import use_case.todo_list.import1.ImportToDoListOutputData;

public interface ToDoPanelOutputBoundary {
    void prepareInitializeSuccessView(ToDoPanelOutputData toDoPanelOutputData);
    void prepareImportToDoListFailView(ImportToDoListOutputData outputData);
    void prepareImportToDoListSuccessView(ImportToDoListOutputData outputData);
    void prepareInitializeFailView(ToDoPanelOutputData toDoPanelOutputData);
}
