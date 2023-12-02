package interface_adapter.todo_list.add;

import interface_adapter.ViewManagerModel;
import interface_adapter.todo_list.ToDoListViewModel;
import use_case.todo_list.add.AddToDoListOutputBoundary;
import use_case.todo_list.add.AddToDoListOutputData;

public class AddToDoListPresenter implements AddToDoListOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AddToDoListViewModel addToDoListViewModel;
    private final ToDoListViewModel toDoListViewModel;

    public AddToDoListPresenter(ViewManagerModel viewManagerModel,
                                AddToDoListViewModel addToDoListViewModel,
                                ToDoListViewModel toDoListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addToDoListViewModel = addToDoListViewModel;
        this.toDoListViewModel = toDoListViewModel;
    }

    /**
     * namely
     * logic: 1. pass new ToDoList into state to let ToDoListViewModel use.
     *        2. send state and a state name that represent the success of adding.
     *        3. send state(meaningless) and a state name says: create successful.
     *        3. change active view.
     * @param outputData A standard outputData get from Interactor and userDAO.
     */
    @Override
    public void prepareSuccessView(AddToDoListOutputData outputData) {
        if (outputData.isUseCaseFailed()) {
            return;
        }
        toDoListViewModel.getState().setNewCreatedTDL(outputData.getToDoList());
        toDoListViewModel.firePropertyChanged(ToDoListViewModel.CREATE_TODO_LIST);
        addToDoListViewModel.firePropertyChanged(AddToDoListViewModel.CREATE_TODO_LIST);
        viewManagerModel.setActiveView(toDoListViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(AddToDoListOutputData outputData) {
        if (!outputData.isUseCaseFailed()) {
            return;
        }
        toDoListViewModel.getState().setError(outputData.getError());
        addToDoListViewModel.getState().setATDLSError(outputData.getError());
        toDoListViewModel.firePropertyChanged(ToDoListViewModel.CREATE_TODO_LIST_FAILED);
        addToDoListViewModel.firePropertyChanged(AddToDoListViewModel.CREATE_TODO_LIST_FAILED);


    }
}
