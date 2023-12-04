package use_case.todo_list;

import data_access.todolist.ToDoListDataAccessInterface;
import entities.todo.CommonToDo;
import entities.todo.CommonToDoFactory;
import entities.todo.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.todo_panel.ToDoPanelOutputBoundary;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListInteractorTest {
    private ToDoListDataAccessInterface userDAO;
    private ToDoListOutputBoundary presenter;
    private ToDoListInputBoundary interactor;

    @BeforeEach
    void setUp() {
        userDAO = new ToDoListDataAccessInterface() {
            @Override
            public List<ToDo> importToDo(long projectID, long toDoListID) {
                if (toDoListID == 0){
                    return null;
                }
                List<ToDo> toDoList = new ArrayList<>();
                String[] strings = {};
                toDoList.add(CommonToDoFactory.create(1,"", strings, ""));
                return toDoList;
            }

            @Override
            public String getApiErrorMessage() {
                return "null";
            }
        };
        presenter = new ToDoListOutputBoundary() {
            @Override
            public void prepareFailView(ToDoListOutputData toDoListOutputData) {
                assertTrue(toDoListOutputData.useCaseFailed());
            }

            @Override
            public void prepareImportView(ToDoListOutputData toDoListOutputData) {
                assertFalse(toDoListOutputData.useCaseFailed());
            }
        };
        interactor = new ToDoListInteractor(presenter, userDAO);
    }

    @Test
    void execute() {
        interactor.execute(new ToDoListInputData(1, 0 ));
        interactor.execute(new ToDoListInputData(1, 1));
    }
}