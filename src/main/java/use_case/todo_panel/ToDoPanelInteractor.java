package use_case.todo_panel;

import data_access.todopanel.ToDoPanelDataAccessInterface;
import entities.todo_panel.ToDoPanel;

public class ToDoPanelInteractor implements ToDoPanelInputBoundary{
    private final ToDoPanelDataAccessInterface userDAO;
    private final ToDoPanelOutputBoundary toDoPanelPresenter;

    public ToDoPanelInteractor(ToDoPanelDataAccessInterface toDoPanelDataAccessObject,
                               ToDoPanelOutputBoundary toDoPanelPresenter) {
        this.userDAO = toDoPanelDataAccessObject;
        this.toDoPanelPresenter = toDoPanelPresenter;
    }

    /**
     * Achieve the main function of ToDoPanel
     *
     * @param toDoPanelInputData for sth. purpose
     */
    @Override
    public void execute(ToDoPanelInputData toDoPanelInputData) {
        ToDoPanel toDoPanel = userDAO.getToDoPanel(0); // TODO: fix here.
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
