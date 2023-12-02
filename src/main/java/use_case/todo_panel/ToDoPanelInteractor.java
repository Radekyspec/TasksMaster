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
    public void importToDoList(ToDoPanelInputData toDoPanelInputData) {
        ToDoPanel toDoPanel = userDAO.importToDoPanel(
                toDoPanelInputData.getProjectID()
        );
        if (toDoPanel == null) {
            ToDoPanelOutputData outputData = new ToDoPanelOutputData(
                    userDAO.getApiErrorMessage(),
                    true,
                    null);
            toDoPanelPresenter.prepareInitializeFailView(outputData);
        } else {
            ToDoPanelOutputData outputData = new ToDoPanelOutputData(
                    userDAO.getApiErrorMessage(),
                    false,
                    toDoPanel);
            toDoPanelPresenter.prepareInitializeSuccessView(outputData);
        }
    }
}
