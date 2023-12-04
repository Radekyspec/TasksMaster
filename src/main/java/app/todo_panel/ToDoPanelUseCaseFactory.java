package app.todo_panel;

import data_access.todopanel.ToDoPanelDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_list.add.AddToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelController;
import interface_adapter.todo_panel.ToDoPanelPresenter;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import use_case.todo_panel.ToDoPanelInputBoundary;
import use_case.todo_panel.ToDoPanelInteractor;
import use_case.todo_panel.ToDoPanelOutputBoundary;
import view.todo_panel.ToDoPanelView;

public class ToDoPanelUseCaseFactory {
    private ToDoPanelUseCaseFactory() {}

    public static ToDoPanelView create(ViewManagerModel viewManagerModel, AddToDoListViewModel addToDoListViewModel,MainProjectViewModel mainProjectViewModel,
                                       ToDoPanelViewModel toDoPanelViewModel, ToDoListViewModel toDoListViewModel,
                                       ToDoPanelDataAccessInterface userDAO) {
        ToDoPanelController controller = createController(toDoPanelViewModel, userDAO);
        return new ToDoPanelView(
                viewManagerModel, toDoPanelViewModel, addToDoListViewModel, mainProjectViewModel, viewManagerModel, controller, toDoListViewModel);
    }

    public static ToDoPanelController createController(
            ToDoPanelViewModel toDoPanelViewModel,
            ToDoPanelDataAccessInterface userDAO) {
        ToDoPanelOutputBoundary presenter = new ToDoPanelPresenter(toDoPanelViewModel);
        ToDoPanelInputBoundary interactor = new ToDoPanelInteractor(userDAO, presenter);
        return new ToDoPanelController(interactor);
    }
}
