package app.todo;

import data_access.todo.add.AddToDoUserDataAccessInterface;
import entities.todo.ToDo;
import interface_adapter.ViewManagerModel;
import interface_adapter.todo.add_todo.AddToDoController;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListViewModel;
import org.junit.jupiter.api.Test;
import view.todo.AddToDoView;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class AddToDoUseCaseFactoryTest {

    @Test
    void create() {
        assertInstanceOf(AddToDoView.class, AddToDoUseCaseFactory.create(
                new ViewManagerModel(),
                new AddToDoViewModel(),
                new ToDoListViewModel(),
                new AddToDoUserDataAccessInterface() {
                    @Override
                    public ToDo createToDo(long projectID, long listID, String target, String progress) {
                        return null;
                    }

                    @Override
                    public String getApiErrorMessage() {
                        return null;
                    }
                }
        ));
    }

    @Test
    void createController() {
        assertInstanceOf(AddToDoController.class, AddToDoUseCaseFactory.createController(
                new ViewManagerModel(),
                new AddToDoViewModel(),
                new ToDoListViewModel(),
                new AddToDoUserDataAccessInterface() {
                    @Override
                    public ToDo createToDo(long projectID, long listID, String target, String progress) {
                        return null;
                    }

                    @Override
                    public String getApiErrorMessage() {
                        return null;
                    }
                }
        ));
    }
}