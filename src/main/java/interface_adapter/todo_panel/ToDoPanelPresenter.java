package interface_adapter.todo_panel;

import interface_adapter.ViewManagerModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import use_case.todo_panel.ToDoPanelOutputBoundary;
import use_case.todo_panel.ToDoPanelOutputData;

public class ToDoPanelPresenter implements ToDoPanelOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final ToDoPanelViewModel toDoPanelViewModel;
    private ToDoPanelPresenter(ViewManagerModel viewManagerModel,
                               ToDoPanelViewModel toDoPanelViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.toDoPanelViewModel = toDoPanelViewModel;

    }
    @Override
    public void prepareSuccessView(ToDoPanelOutputData toDoPanelOutputData) {
        if (toDoPanelOutputData.isUseCaseFailed()) {
            return;
        }
        toDoPanelViewModel.firePropertyChanged(); // fire之后，todopanelview那边的一个不间断监听的listener，
        viewManagerModel.setActiveView(toDoPanelViewModel.getViewName());
    }

    @Override
    public void prepareFailView(ToDoPanelOutputData toDoPanelOutputData) {
        if (!toDoPanelOutputData.isUseCaseFailed()) {
            return;
        }
        toDoPanelViewModel.getToDoPanelState().setToDoPanelError(toDoPanelOutputData.getError());
        toDoPanelViewModel.firePropertyChanged(); //之后呢？？

    }
}
