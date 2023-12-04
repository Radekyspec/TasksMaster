package use_case.todo_panel;

public interface ToDoPanelOutputBoundary {
    void prepareInitializeSuccessView(ToDoPanelOutputData toDoPanelOutputData);
    void prepareInitializeFailView(ToDoPanelOutputData toDoPanelOutputData);
}
