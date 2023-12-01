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
        toDoPanelViewModel.getToDoPanelState().setWorkKind(toDoPanelOutputData.getWorkKind()); //这一行将viewmodel里的state的内容设置为outputdata里的panel。注意要写好方法，todooutputdata要有gettodopanel来得到todopanel，然后再喂给viewmodel里的gettodopanel（list）
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
