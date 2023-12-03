package interface_adapter.todo.add_todo;

import interface_adapter.ViewManagerModel;
import interface_adapter.todo.ToDoViewModel;
import interface_adapter.todo_list.ToDoListViewModel;
import use_case.todo.add.AddToDoOutputBoundary;
import use_case.todo.add.AddToDoOutputData;

public class AddToDoPresenter implements AddToDoOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AddToDoViewModel addToDoViewModel;
    private final ToDoViewModel toDoViewModel;
    private final ToDoListViewModel toDoListViewModel;

    public AddToDoPresenter(ViewManagerModel viewManagerModel,
                            AddToDoViewModel addToDoViewModel,
                            ToDoViewModel toDoViewModel,
                            ToDoListViewModel toDoListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addToDoViewModel = addToDoViewModel;
        this.toDoViewModel = toDoViewModel;
        this.toDoListViewModel = toDoListViewModel;
    }

    @Override
    public void prepareSuccessView(AddToDoOutputData outputData) {
        if (outputData.isUseCaseFailed()) {
            return;
        }
//        toDoViewModel.getState().setNewCreatedToDo(outputData.getToDo());
//        addToDoViewModel.firePropertyChanged(AddToDo);
    }

    @Override
    public void prepareFailView(AddToDoOutputData outputData) {

    }
}
