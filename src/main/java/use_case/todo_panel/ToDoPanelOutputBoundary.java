package use_case.todo_panel;

public interface ToDoPanelOutputBoundary {
    void prepareSuccessView(ToDoPanelOutputData toDoPanelOutputData);

    void prepareFailView(ToDoPanelOutputData toDoPanelOutputData);
}
