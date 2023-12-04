package app.todo_panel;

import data_access.todopanel.ToDoPanelDataAccessInterface;
import entities.todo_list.ToDoList;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_list.add.AddToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelController;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import org.junit.jupiter.api.Test;
import view.todo_panel.ToDoPanelView;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ToDoPanelUseCaseFactoryTest {

    @Test
    void create() {
        assertInstanceOf(ToDoPanelView.class, ToDoPanelUseCaseFactory.create(
                new ViewManagerModel(),
                new AddToDoListViewModel(),
                new MainProjectViewModel(),
                new ToDoPanelViewModel(),
                new ToDoListViewModel(),
                new ToDoPanelDataAccessInterface() {
                    @Override
                    public List<ToDoList> importToDoList(long projectID, long toDoPanelID) {
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
        assertInstanceOf(ToDoPanelController.class, ToDoPanelUseCaseFactory.createController(
                new ToDoPanelViewModel(),
                new ToDoPanelDataAccessInterface() {
                    @Override
                    public List<ToDoList> importToDoList(long projectID, long toDoPanelID) {
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