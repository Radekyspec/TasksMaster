package app.todo_list;

import data_access.todolist.ToDoListDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListController;
import interface_adapter.todo_list.ToDoListPresenter;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import use_case.todo_list.ToDoListInputBoundary;
import use_case.todo_list.ToDoListInteractor;
import use_case.todo_list.ToDoListOutputBoundary;
import view.todo_list.ToDoListView;

public class ToDoListUseCaseFactory {
    private ToDoListUseCaseFactory() {
    }

    public static ToDoListView create(
            ViewManagerModel viewManagerModel, ToDoListViewModel toDoListViewModel, MainProjectViewModel mainProjectViewModel,
            ToDoPanelViewModel toDoPanelViewModel, AddToDoViewModel addToDoViewModel,
            ToDoListDataAccessInterface toDoListDataAccessInterface) {
        ToDoListController controller = createController(viewManagerModel, toDoListViewModel, toDoListDataAccessInterface);
        return new ToDoListView(viewManagerModel, toDoListViewModel, mainProjectViewModel, toDoPanelViewModel,
                addToDoViewModel, controller);
    }

    public static ToDoListController createController(
            ViewManagerModel viewManagerModel, ToDoListViewModel toDoListViewModel,
            ToDoListDataAccessInterface toDoListDataAccessInterface
    ) {
        ToDoListOutputBoundary presenter = new ToDoListPresenter(viewManagerModel, toDoListViewModel);
        ToDoListInputBoundary interactor = new ToDoListInteractor(presenter, toDoListDataAccessInterface);
        return new ToDoListController(interactor);
    }
}
