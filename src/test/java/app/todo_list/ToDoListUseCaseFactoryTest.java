package app.todo_list;

import data_access.todolist.ToDoListDataAccessInterface;
import entities.todo.ToDo;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListController;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import org.junit.jupiter.api.Test;
import view.todo_list.ToDoListView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListUseCaseFactoryTest {

    @Test
    void create() {
        assertInstanceOf(ToDoListView.class, ToDoListUseCaseFactory.create(
                new ViewManagerModel(),
                new ToDoListViewModel(),
                new MainProjectViewModel(),
                new ToDoPanelViewModel(),
                new AddToDoViewModel(),
                new ToDoListDataAccessInterface() {
                    @Override
                    public List<ToDo> importToDo(long projectID, long toDoListID) {
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
        assertInstanceOf(ToDoListController.class, ToDoListUseCaseFactory.createController(
                new ViewManagerModel(),
                new ToDoListViewModel(),
                new ToDoListDataAccessInterface() {
                    @Override
                    public List<ToDo> importToDo(long projectID, long toDoListID) {
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