package use_case.todo_panel;

import data_access.todopanel.ToDoPanelDataAccessInterface;
import entities.todo.ToDo;
import entities.todo_panel.ToDoPanel;
import entities.user.CommonUserFactory;
import entities.user.User;
import use_case.signup.SignupOutputData;

import java.time.LocalDateTime;

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
        ToDoPanel toDoPanel = toDoPanelDataAccessObject.getToDoPanel();
        if (toDoPanel == null) {
            // 此处将获取的todopanel传入进去了，通过outputdata传入todopanelpresenter
            ToDoPanelOutputData outputData = new ToDoPanelOutputData(
                    "TDPDAO-getToDoPanel: Failure.",
                    null,
                    true
            );
            toDoPanelPresenter.prepareFailView(outputData);
        } else {
            ToDoPanelOutputData outputData = new ToDoPanelOutputData(
                    "",
                    toDoPanel,
                    false
            );
            toDoPanelPresenter.prepareSuccessView(outputData);
        }
    }
}
