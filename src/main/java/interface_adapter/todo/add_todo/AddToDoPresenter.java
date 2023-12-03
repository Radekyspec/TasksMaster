package interface_adapter.todo.add_todo;

import interface_adapter.ViewManagerModel;
import interface_adapter.todo_list.ToDoListViewModel;
import use_case.todo.add.AddToDoOutputBoundary;
import use_case.todo.add.AddToDoOutputData;

public class AddToDoPresenter implements AddToDoOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AddToDoViewModel addToDoViewModel;
    private final ToDoListViewModel toDoListViewModel;

    public AddToDoPresenter(ViewManagerModel viewManagerModel,
                            AddToDoViewModel addToDoViewModel,
                            ToDoListViewModel toDoListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addToDoViewModel = addToDoViewModel;
        this.toDoListViewModel = toDoListViewModel;
    }

    @Override
    public void prepareSuccessView(AddToDoOutputData outputData) {
        if (outputData.isUseCaseFailed()) {
            return;
        }

        toDoListViewModel.getState().setNewToDo(outputData.getToDo());
        toDoListViewModel.firePropertyChanged(ToDoListViewModel.IMPORT_SINGLE_TODO);
        viewManagerModel.setActiveView(toDoListViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(AddToDoOutputData outputData) {
        toDoListViewModel.getState().setError(outputData.getError());
        toDoListViewModel.firePropertyChanged(ToDoListViewModel.IMPORT_TODO_LIST_FAILED);
    }
}
