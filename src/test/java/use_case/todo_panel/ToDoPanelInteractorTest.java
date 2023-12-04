package use_case.todo_panel;

import data_access.todopanel.ToDoPanelDataAccessInterface;
import entities.todo_list.CommonToDoList;
import entities.todo_list.CommonToDoListFactory;
import entities.todo_list.ToDoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoPanelInteractorTest {
    private ToDoPanelDataAccessInterface userDAO;
    private ToDoPanelOutputBoundary presenter;
    private ToDoPanelInputBoundary interactor;
    @BeforeEach
    void setUp() {
        userDAO = new ToDoPanelDataAccessInterface() {
            @Override
            public List<ToDoList> importToDoList(long projectID, long toDoPanelID) {
                if (toDoPanelID == 0){
                    return null;
                }
                List<ToDoList> toDoLists = new ArrayList<>();
                toDoLists.add(CommonToDoListFactory.create(1,1,"name", "detail"));
                return toDoLists;
            }

            @Override
            public String getApiErrorMessage() {
                return "123";
            }
        };
        presenter = new ToDoPanelOutputBoundary() {
            @Override
            public void prepareInitializeSuccessView(ToDoPanelOutputData toDoPanelOutputData) {
                assertFalse(toDoPanelOutputData.useCaseFailed());
            }

            @Override
            public void prepareInitializeFailView(ToDoPanelOutputData toDoPanelOutputData) {
                assertTrue(toDoPanelOutputData.useCaseFailed());
            }
        };
        interactor = new ToDoPanelInteractor(userDAO, presenter);
    }

    @Test
    void importToDoList() {
        interactor.importToDoList(new ToDoPanelInputData(1, 0));
        interactor.importToDoList(new ToDoPanelInputData(1,1));
    }
}