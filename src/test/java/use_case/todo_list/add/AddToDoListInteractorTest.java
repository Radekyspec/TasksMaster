package use_case.todo_list.add;

import data_access.todolist.add.AddToDoListUserDataAccessInterface;
import entities.todo_list.CommonToDoListFactory;
import entities.todo_list.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddToDoListInteractorTest {
    private AddToDoListUserDataAccessInterface userDAO;
    private AddToDoListOutputBoundary presenter;
    private AddToDoListInputBoundary interactor;

    @BeforeEach
    void setUp() {
        userDAO = new AddToDoListUserDataAccessInterface() {
            @Override
            public ToDoList createToDoList(long projectID, long toDoPanelID, String name, String detail) {
                if (toDoPanelID == 0) {
                    return null;
                }
                return CommonToDoListFactory.create(1, 1, "name", "detail");
            }

            @Override
            public String getApiErrorMessage() {
                return "null";
            }
        };
        presenter = new AddToDoListOutputBoundary() {
            @Override
            public void prepareSuccessView(AddToDoListOutputData outputData) {
                assertFalse(outputData.useCaseFailed());
            }

            @Override
            public void prepareFailView(AddToDoListOutputData outputData) {
                assertTrue(outputData.useCaseFailed());
            }
        };
        interactor = new AddToDoListInteractor(presenter, userDAO);
    }

    @Test
    void execute() {
        interactor.execute(new AddToDoListInputData("", "", 0, 1));
        interactor.execute(new AddToDoListInputData("", "", 1, 1));
    }
}