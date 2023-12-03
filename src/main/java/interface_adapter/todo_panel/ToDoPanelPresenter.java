package interface_adapter.todo_panel;

import entities.todo_list.ToDoList;
import use_case.todo_list.import1.ImportToDoListOutputData;
import use_case.todo_panel.ToDoPanelOutputBoundary;
import use_case.todo_panel.ToDoPanelOutputData;

public class ToDoPanelPresenter implements ToDoPanelOutputBoundary {
    private final ToDoPanelViewModel toDoPanelViewModel;
    private ToDoPanelPresenter(ToDoPanelViewModel toDoPanelViewModel) {
        this.toDoPanelViewModel = toDoPanelViewModel;

    }

    @Override
    public void prepareInitializeSuccessView(ToDoPanelOutputData toDoPanelOutputData) {
        if (toDoPanelOutputData.isUseCaseFailed()) {
            return;
        }
        toDoPanelViewModel.getState().setCurrentToDoPanel(toDoPanelOutputData.getToDoPanel());
        toDoPanelViewModel.firePropertyChanged(ToDoPanelViewModel.INITIALIZE_TODO_PANEL);
    }

    @Override
    public void prepareImportToDoListSuccessView(ImportToDoListOutputData outputData) {
        if (outputData.isUseCaseFailed()) {
            return;
        }
        for (ToDoList toDoList : outputData.getListOfToDo()) {
            toDoPanelViewModel.getState().setListOfToDoList(toDoList);
            toDoPanelViewModel.firePropertyChanged(ToDoPanelViewModel.IMPORT_TODOLIST);
        }

    }

    @Override
    public void prepareImportToDoListFailView(ImportToDoListOutputData outputData) {
        if (!outputData.isUseCaseFailed()) {
            return;
        }
        toDoPanelViewModel.getState().setToDoPanelError(outputData.getError());
        toDoPanelViewModel.firePropertyChanged(ToDoPanelViewModel.IMPORT_TODOLIST_FAILED);
    }

    @Override
    public void prepareInitializeFailView(ToDoPanelOutputData toDoPanelOutputData) {
        if (!toDoPanelOutputData.isUseCaseFailed()) {
            return;
        }
        toDoPanelViewModel.getState().setToDoPanelError(toDoPanelOutputData.getError());
        toDoPanelViewModel.firePropertyChanged(ToDoPanelViewModel.INITIALIZE_TODO_PANEL_FAILED);
    }
}
