package use_case.todo.add;

import data_access.todo.add.AddToDoUserDataAccessInterface;
import entities.todo.ToDo;

public class AddToDoInteractor implements AddToDoInputBoundary {
    private final AddToDoOutputBoundary addToDoPresenter;
    private final AddToDoUserDataAccessInterface userDAO;

    public AddToDoInteractor(AddToDoOutputBoundary presenter,
                             AddToDoUserDataAccessInterface userDAO) {
        this.addToDoPresenter = presenter;
        this.userDAO = userDAO;
    }

    /**
     * Main logic of Adding ToDoLists.
     * First create a ToDoList using AddToDoListUserDataInterface.
     * Then judge if the new ToDoList is or is not null.
     * userDAO will return null if anything goes wrong in the code.
     * if toDoList == null, add error message to outputData and prepare failed view.
     * if toDoList is not null, add new ToDoList to outputData and prepare success view.
     *
     * @param inputData A standard AddToDoListInputData.
     */
    @Override
    public void importAddToDoList(AddToDoInputData inputData) {
        ToDo toDo = userDAO.createToDo(
                inputData.projectID(),
                inputData.toDoListID(),
                inputData.target(),
                inputData.progress());
        if (toDo == null) {
            AddToDoOutputData outputData = new AddToDoOutputData(
                    null,
                    userDAO.getApiErrorMessage(),
                    true
            );
            addToDoPresenter.prepareFailView(outputData);
        } else {
            AddToDoOutputData outputData = new AddToDoOutputData(
                    toDo,
                    null,
                    false
            );
            addToDoPresenter.prepareSuccessView(outputData);
        }
    }
}
