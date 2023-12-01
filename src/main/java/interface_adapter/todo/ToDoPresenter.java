package interface_adapter.todo;

import entities.todo.ToDo;
import interface_adapter.ViewManagerModel;
import use_case.todo.ToDoOutputBoundary;
import use_case.todo.ToDoOutputData;

import java.util.Map;

public class ToDoPresenter implements ToDoOutputBoundary {

    private final ToDoViewModel toDoViewModel;
    private final ViewManagerModel viewManagerModel;

    public ToDoPresenter(ViewManagerModel viewManagerModel,
                             ToDoViewModel toDoViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.toDoViewModel = toDoViewModel;
    }
    
    /**
     * namely
     *
     * @param toDoOutputData get output data from Interactor ONLY.
     */
    @Override
    public void prepareFailView(ToDoOutputData toDoOutputData) {
        if (!toDoOutputData.isUseCaseFailed()) {
            return;
        }
        toDoViewModel.getToDoState().setToDoError(toDoOutputData.getError());
        toDoViewModel.getToDoState().setWorkKind(toDoOutputData.getWorkKind());
        toDoViewModel.firePropertyChanged();
    }

    /**
     * namely
     *
     * @param toDoOutputData get output data from Interactor ONLY.
     */
    @Override
    public void prepareCreateView(ToDoOutputData toDoOutputData) {
        if (toDoOutputData.isUseCaseFailed()) {
            return;
        }
        toDoViewModel.getToDoState().setTarget(toDoOutputData.getTarget());
        toDoViewModel.getToDoState().setAssignTo(toDoOutputData.getAssignTo());
        toDoViewModel.getToDoState().setProgress(toDoOutputData.getProgress());
        toDoViewModel.getToDoState().setWorkKind(toDoOutputData.getWorkKind());
        toDoViewModel.firePropertyChanged();
    }

    /**
     * namely
     *
     * @param toDoOutputData get output data from Interactor ONLY.
     */
    @Override
    public void prepareImportView(ToDoOutputData toDoOutputData) {
        if (toDoOutputData.isUseCaseFailed()) {
            return;
        }
        Map<Integer, ToDo> TDPPackage = toDoOutputData.getToDoPackage();
        toDoViewModel.getToDoState().getToDoPackage().putAll(TDPPackage);
        toDoViewModel.getToDoState().setWorkKind(toDoOutputData.getWorkKind());
        viewManagerModel.setActiveView(toDoViewModel.getViewName()); // import 完后才能进入view
        toDoViewModel.firePropertyChanged();
    }
}
