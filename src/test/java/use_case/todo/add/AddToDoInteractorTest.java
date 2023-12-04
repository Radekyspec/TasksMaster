package use_case.todo.add;

import data_access.todo.add.AddToDoUserDataAccessInterface;
import entities.todo.CommonToDoFactory;
import entities.todo.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddToDoInteractorTest {
    private AddToDoOutputBoundary presenter;
    private AddToDoInputBoundary interactor;
    private AddToDoUserDataAccessInterface userDAO;

    @BeforeEach
    void setUp() {
        presenter = new AddToDoOutputBoundary() {
            @Override
            public void prepareSuccessView(AddToDoOutputData outputData) {
                assertFalse(outputData.isUseCaseFailed());
                assertNull(outputData.getError());
            }

            @Override
            public void prepareFailView(AddToDoOutputData outputData) {
                assertTrue(outputData.isUseCaseFailed());
                assertNull(outputData.getToDo());
            }
        };
        userDAO = new AddToDoUserDataAccessInterface() {
            @Override
            public ToDo createToDo(long projectID, long listID, String target, String progress) {
                if (listID == 0) {
                    return null;
                }
                return CommonToDoFactory.create(
                        0, target, new String[]{}, progress
                );
            }

            @Override
            public String getApiErrorMessage() {
                return "API ERROR";
            }
        };
        interactor = new AddToDoInteractor(presenter, userDAO);
    }

    @Test
    void importAddToDoList() {
        interactor.importAddToDoList(new AddToDoInputData("", "", 0, 1));
        interactor.importAddToDoList(new AddToDoInputData("", "", 1, 1));
    }
}