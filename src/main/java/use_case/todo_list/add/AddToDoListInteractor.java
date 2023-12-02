package use_case.todo_list.add;

import data_access.todolist.add.AddToDoListUserDataAccessInterface;
import entities.todo_list.ToDoList;

public class AddToDoListInteractor implements AddToDoListInputBoundary{
    private final AddToDoListOutputBoundary addToDoListPresenter;
    private final AddToDoListUserDataAccessInterface userDAO;

    public AddToDoListInteractor(AddToDoListOutputBoundary presenter,
                                 AddToDoListUserDataAccessInterface userDAO) {
        this.addToDoListPresenter = presenter;
        this.userDAO = userDAO;
    }

    /**
     * Main logic of Adding ToDoLists.
     *   First create a ToDoList using AddToDoListUserDataInterface.
     *   Then judge if the new ToDoList is or is not null.
     *     userDAO will return null if anything goes wrong in the code.
     *   if toDoList == null, add error message to outputData and prepare failed view.
     *   if toDoList is not null, add new ToDoList to outputData and prepare success view.
     * @param inputData A standard AddToDoListInputData.
     */
    @Override
    public void execute(AddToDoListInputData inputData) {
        ToDoList toDoList = userDAO.createToDoList(
                inputData.getProjectID(),
                inputData.getListID(),
                inputData.getName(),
                inputData.getDetail()
        );
        if (toDoList == null) {
            AddToDoListOutputData outputData = new AddToDoListOutputData(
                    null,
                    userDAO.getApiErrorMessage(),
                    true
            );
            addToDoListPresenter.prepareFailView(outputData);
        } else {
            AddToDoListOutputData outputData = new AddToDoListOutputData(
                    toDoList,
                    null,
                    false
            );
            addToDoListPresenter.prepareSuccessView(outputData);
        }
    }
}
