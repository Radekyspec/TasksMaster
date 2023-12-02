package interface_adapter.todo_list;

import interface_adapter.ViewManagerModel;
import use_case.todo_list.ToDoListOutputBoundary;
import use_case.todo_list.ToDoListOutputData;

public class ToDoListPresenter implements ToDoListOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final ToDoListViewModel toDoListViewModel;
    private boolean isDone;

    @Override
    public void setDone(boolean stage) {
        isDone = stage;
    }

    public ToDoListPresenter(ViewManagerModel viewManagerModel,
                             ToDoListViewModel toDoListViewModel,
                             boolean isDone) {
        this.viewManagerModel = viewManagerModel;
        this.toDoListViewModel = toDoListViewModel;
        this.isDone = isDone;
    }

    /**
     * namely
     * Show import fail view. Nothing except error message will be passed.
     *
     * @param toDoListOutputData get output data.
     */
    @Override
    public void prepareFailView(ToDoListOutputData toDoListOutputData) {
        if (!toDoListOutputData.isUseCaseFailed()) {
            return;
        }
        toDoListViewModel.getState().setError(toDoListOutputData.getError());
        toDoListViewModel.firePropertyChanged(ToDoListViewModel.IMPORT_TODO_LIST_FAILED);
    }

    /**
     * namely
     * Import ToDos one by one.
     * Find adding new ToDos in AddToDoInteractor/Presenter/View.
     *     This Presenter only in charges of importing ToDos.
     *
     * @param outputData get output data.
     */
    @Override
    public void prepareImportView(ToDoListOutputData outputData) {
        if (outputData.isUseCaseFailed()) {
            return;
        }
        if (this.isDone) {
            viewManagerModel.setActiveView(toDoListViewModel.getViewName());
            toDoListViewModel.firePropertyChanged(ToDoListViewModel.IMPORT_TODO_LIST);
        } else {
            toDoListViewModel.getState().setListOfToDo(outputData.getToDo());
        }
    }



}
