package use_case.todo_panel;

public interface ToDoPanelOutputBoundary {
    void prepareInitializeSuccessView(ToDoPanelOutputData toDoPanelOutputData);
    void prepareImportToDoListFailView(ImportToDoListOutputData outputData);
    void prepareImportToDoListSuccessView(ImportToDoListOutputData outputData);
    void prepareInitializeFailView(ToDoPanelOutputData toDoPanelOutputData);
}
