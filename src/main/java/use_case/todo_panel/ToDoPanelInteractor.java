package use_case.todo_panel;

import data_access.todopanel.ToDoPanelDataAccessInterface;
import entities.todo_panel.ToDoPanel;

public class ToDoPanelInteractor implements ToDoPanelInputBoundary{
    private final ToDoPanelDataAccessInterface toDoPanelDataAccessObject;
    private final ToDoPanelOutputBoundary toDoPanelPresenter;

    public ToDoPanelInteractor(ToDoPanelDataAccessInterface toDoPanelDataAccessObject,
                               ToDoPanelOutputBoundary toDoPanelPresenter) {
        this.toDoPanelDataAccessObject = toDoPanelDataAccessObject;
        this.toDoPanelPresenter = toDoPanelPresenter;
    }

    /**
     * Achieve the main function of ToDoPanel
     *
     * @param toDoPanelInputData for sth. purpose
     */
    @Override
    public void execute(ToDoPanelInputData toDoPanelInputData) {
        // 此处将获取的ToDoPanel传入进去了，通过OutputData传入ToDoPanelPresenter
        ToDoPanel toDoPanel = toDoPanelDataAccessObject.getToDoPanel();
        if (toDoPanel == null) {
            ToDoPanelOutputData outputData = new ToDoPanelOutputData(
                    null,
                    "TDPInteractor: get failure.",
                    null,
                    true);
            toDoPanelPresenter.prepareFailView(outputData);
        }
        if (toDoPanelInputData.getWorkKind().equals("Initialize")) {
            ToDoPanelOutputData outputData = new ToDoPanelOutputData(
                    "Initialize",
                    "",
                    toDoPanel,
                    false);
            toDoPanelPresenter.prepareSuccessView(outputData);
        }
    }
}
