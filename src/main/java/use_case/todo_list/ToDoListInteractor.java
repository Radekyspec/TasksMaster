package use_case.todo_list;

import data_access.todolist.ToDoListDataAccessInterface;
import entities.todo.ToDo;

import java.util.List;

public class ToDoListInteractor implements ToDoListInputBoundary{
    private final ToDoListOutputBoundary toDoListPresenter;
    private final ToDoListDataAccessInterface userDAO;

    public ToDoListInteractor(ToDoListOutputBoundary toDoListPresenter, ToDoListDataAccessInterface userDAO) {
        this.toDoListPresenter = toDoListPresenter;
        this.userDAO = userDAO;
    }

    /**
     * workKind is NOT IN USE and be ready to dispose.
     * Only one logic is running here, which is import.
     * logic: 1. receive List<To_Do></> from userDAO. ?See AddToDoInteractor for reference.
     *        2. judge if the List is or is not null, as userDAO should return null of anything goes wrong.
     *        3. if it's null, add error message to outputData and prepare failed view.
     *        4. if it's not null, use a for loop to pass multiple times of outputData.
     *          4.1 each outputData contains one To_Do.
     *          4.2 presenter will continue firing property change until the last To_Do passed.
     *          4.3 those To_Do will be stored in ToDoListState.
     *            4.3.1 We use ToDoListInteractor to split the list. Because we want Presenter to be pure.
     *            4.3.2 We modify the methods in ToDoListState, makes it be able to receive single To_Do and
     *                integrate them into a list.
     *            4.3.3 We don't store To_Do in ToDoView, we will only have AddToDoView.
     * ToDo: delete the logic that pass toDoListPackage from ToDoListController all the way to here.
     *       you need to delete those logic on:
     *       ToDoListController, ToDoList InputData, ToDoListInteractor, ToDoListOutputData, ToDoListPresenter
     *       ToDoListViewModel and ToDoListView.
     * TODO: delete the use of workKind In ToDoList, ToDo and ToDoPanel. Use searching engine.
     *
     * @param toDoListInputData A standard ToDoListInputData
     */
    @Override
    public void execute(ToDoListInputData toDoListInputData) {
        List<ToDo> listOfToDo = userDAO.importToDo(
                toDoListInputData.getProjectID(),
                toDoListInputData.getToDoListID());
        if (listOfToDo == null) {
            ToDoListOutputData outputData = new ToDoListOutputData(
                    true,
                    userDAO.getApiErrorMessage(),
                    null);
            toDoListPresenter.prepareFailView(outputData);
        } else {
            toDoListPresenter.setDone(false);
            for (ToDo toDo : listOfToDo) {
                ToDoListOutputData outputData = new ToDoListOutputData(
                        false,
                        userDAO.getApiErrorMessage(),
                        toDo);
                toDoListPresenter.prepareImportView(outputData);
            }
            toDoListPresenter.setDone(true);
        }
    }
}
