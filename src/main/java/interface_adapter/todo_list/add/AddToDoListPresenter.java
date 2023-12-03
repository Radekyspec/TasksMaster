package interface_adapter.todo_list.add;

import interface_adapter.ViewManagerModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import use_case.todo_list.add.AddToDoListOutputBoundary;
import use_case.todo_list.add.AddToDoListOutputData;

public class AddToDoListPresenter implements AddToDoListOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AddToDoListViewModel addToDoListViewModel;
    private final ToDoPanelViewModel toDoPanelViewModel;

    public AddToDoListPresenter(ViewManagerModel viewManagerModel,
                                AddToDoListViewModel addToDoListViewModel,
                                ToDoPanelViewModel toDoPanelViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addToDoListViewModel = addToDoListViewModel;
        this.toDoPanelViewModel = toDoPanelViewModel;
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
        toDoPanelViewModel.getState().setNewCreatedTDL(outputData.getToDoList());
        toDoPanelViewModel.firePropertyChanged(ToDoPanelViewModel.IMPORT_TODOLIST);
        addToDoListViewModel.firePropertyChanged(AddToDoListViewModel.CREATE_TODO_LIST);
        viewManagerModel.setActiveView(toDoPanelViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(AddToDoListOutputData outputData) {
        if (!outputData.isUseCaseFailed()) {
            return;
        }
        toDoPanelViewModel.getState().setImportToDoListError(outputData.getError());
        addToDoListViewModel.getState().setATDLSError(outputData.getError());
        toDoPanelViewModel.firePropertyChanged(ToDoPanelViewModel.IMPORT_TODOLIST_FAILED);
        addToDoListViewModel.firePropertyChanged(AddToDoListViewModel.CREATE_TODO_LIST_FAILED);


    }
}
