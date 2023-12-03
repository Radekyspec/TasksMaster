package app.todo;

import data_access.todo.add.AddToDoUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.todo.add_todo.AddToDoController;
import interface_adapter.todo.add_todo.AddToDoPresenter;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListViewModel;
import use_case.todo.add.AddToDoInputBoundary;
import use_case.todo.add.AddToDoInteractor;
import use_case.todo.add.AddToDoOutputBoundary;
import view.todo.AddToDoView;

public class AddToDoUseCaseFactory {
    private AddToDoUseCaseFactory() {}

    public static AddToDoView create(
            ViewManagerModel viewManagerModel, AddToDoViewModel addToDoViewModel, ToDoListViewModel toDoListViewModel,
            AddToDoUserDataAccessInterface userDAO
    ) {
        AddToDoController controller = createController(viewManagerModel, addToDoViewModel, toDoListViewModel, userDAO);
        return new AddToDoView(viewManagerModel, toDoListViewModel, addToDoViewModel, controller);
    }

    public static AddToDoController createController(
            ViewManagerModel viewManagerModel, AddToDoViewModel addToDoViewModel, ToDoListViewModel toDoListViewModel,
            AddToDoUserDataAccessInterface userDAO
    ) {
        AddToDoOutputBoundary presenter = new AddToDoPresenter(
                viewManagerModel, addToDoViewModel, toDoListViewModel
        );
        AddToDoInputBoundary interactor = new AddToDoInteractor(presenter, userDAO);
        return new AddToDoController(interactor);
    }
}
