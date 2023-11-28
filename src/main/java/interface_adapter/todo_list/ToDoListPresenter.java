package interface_adapter.todo_list;

import entities.todo_list.ToDoList;
import interface_adapter.ViewManagerModel;
import use_case.todo_list.ToDoListOutputBoundary;
import use_case.todo_list.ToDoListOutputData;

import java.util.Map;

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
     *
     * @param toDoListOutputData get output data from Interactor ONLY.
     */
    @Override
    public void prepareFailView(ToDoListOutputData toDoListOutputData) {
        if (!toDoListOutputData.isUseCaseFailed()) {
            return;
        }
        toDoListViewModel.getToDoListState().setToDoListError(toDoListOutputData.getError());
        toDoListViewModel.firePropertyChanged();
    }

    /**
     * namely
     *
     * @param toDoListOutputData get output data from Interactor ONLY.
     */
    @Override
    public void prepareCreateView(ToDoListOutputData toDoListOutputData) {
        if (toDoListOutputData.isUseCaseFailed()) {
            return;
        }
        toDoListViewModel.getToDoListState().setName(toDoListOutputData.getName());
        toDoListViewModel.firePropertyChanged();
    }

    /**
     * namely
     *
     * @param toDoListOutputData get output data from Interactor ONLY.
     */
    @Override
    public void prepareImportView(ToDoListOutputData toDoListOutputData) {
        if (toDoListOutputData.isUseCaseFailed()) {
            return;
        }
        Map<Integer, ToDoList> TDPPackage = toDoListOutputData.getToDoListPackage();
        toDoListViewModel.getToDoListState().getToDoListPackage().putAll(TDPPackage);
        toDoListViewModel.firePropertyChanged();
    }
}
