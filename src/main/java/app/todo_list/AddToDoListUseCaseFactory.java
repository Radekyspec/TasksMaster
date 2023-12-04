package app.todo_list;

import data_access.todolist.add.AddToDoListUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.todo_list.add.AddToDoListController;
import interface_adapter.todo_list.add.AddToDoListPresenter;
import interface_adapter.todo_list.add.AddToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import use_case.todo_list.add.AddToDoListInputBoundary;
import use_case.todo_list.add.AddToDoListInteractor;
import use_case.todo_list.add.AddToDoListOutputBoundary;
import view.todo_list.AddToDoListView;

public class AddToDoListUseCaseFactory {
    private AddToDoListUseCaseFactory() {
    }

    public static AddToDoListView create(ViewManagerModel viewManagerModel, AddToDoListViewModel addToDoListViewModel, ToDoPanelViewModel toDoPanelViewModel,
                                         AddToDoListUserDataAccessInterface userDAO) {
        AddToDoListController controller = createController(viewManagerModel, addToDoListViewModel, toDoPanelViewModel, userDAO);
        return new AddToDoListView(
                viewManagerModel, toDoPanelViewModel, addToDoListViewModel, controller
        );
    }

    public static AddToDoListController createController(
            ViewManagerModel viewManagerModel, AddToDoListViewModel addToDoListViewModel, ToDoPanelViewModel toDoPanelViewModel,
            AddToDoListUserDataAccessInterface userDAO
    ) {
        AddToDoListOutputBoundary presenter = new AddToDoListPresenter(viewManagerModel, addToDoListViewModel, toDoPanelViewModel);
        AddToDoListInputBoundary interactor = new AddToDoListInteractor(presenter, userDAO);
        return new AddToDoListController(interactor);
    }
}
