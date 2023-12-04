package interface_adapter.todo_list;

import interface_adapter.ViewManagerModel;
import use_case.todo_list.ToDoListOutputBoundary;
import use_case.todo_list.ToDoListOutputData;

public class ToDoListPresenter implements ToDoListOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final ToDoListViewModel toDoListViewModel;

    public ToDoListPresenter(ViewManagerModel viewManagerModel,
                             ToDoListViewModel toDoListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.toDoListViewModel = toDoListViewModel;
    }

    /**
     * namely
     * Show import fail view. Nothing except error message will be passed.
     *
     * @param toDoListOutputData get output data.
     */
    @Override
    public void prepareFailView(ToDoListOutputData toDoListOutputData) {
        if (!toDoListOutputData.useCaseFailed()) {
            return;
        }
        toDoListViewModel.getState().setError(toDoListOutputData.error());
        toDoListViewModel.firePropertyChanged(ToDoListViewModel.IMPORT_TODO_LIST_FAILED);
    }

    /**
     * namely
     * Import ToDos one by one.
     * Find adding new ToDos in AddToDoInteractor/Presenter/View.
     * This Presenter only in charges of importing ToDos.
     *
     * @param outputData get output data.
     */
    @Override
    public void prepareImportView(ToDoListOutputData outputData) {
        if (outputData.useCaseFailed()) {
            return;
        }
        toDoListViewModel.getState().setListOfToDo(outputData.listOfToDo());
        toDoListViewModel.firePropertyChanged(ToDoListViewModel.IMPORT_TODO);
    }


}
