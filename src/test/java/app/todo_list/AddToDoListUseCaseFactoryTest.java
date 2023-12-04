package app.todo_list;

import data_access.todolist.add.AddToDoListUserDataAccessInterface;
import entities.todo_list.ToDoList;
import interface_adapter.ViewManagerModel;
import interface_adapter.todo_list.add.AddToDoListController;
import interface_adapter.todo_list.add.AddToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import org.junit.jupiter.api.Test;
import view.todo_list.AddToDoListView;

import static org.junit.jupiter.api.Assertions.*;

class AddToDoListUseCaseFactoryTest {

    @Test
    void create() {
        assertInstanceOf(AddToDoListView.class, AddToDoListUseCaseFactory.create(
                new ViewManagerModel(),
                new AddToDoListViewModel(),
                new ToDoPanelViewModel(),
                new AddToDoListUserDataAccessInterface() {
                    @Override
                    public ToDoList createToDoList(long projectID, long toDoPanelID, String name, String detail) {
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
        assertInstanceOf(AddToDoListController.class, AddToDoListUseCaseFactory.createController(
                new ViewManagerModel(),
                new AddToDoListViewModel(),
                new ToDoPanelViewModel(),
                new AddToDoListUserDataAccessInterface() {
                    @Override
                    public ToDoList createToDoList(long projectID, long toDoPanelID, String name, String detail) {
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