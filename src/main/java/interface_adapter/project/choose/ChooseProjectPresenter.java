package interface_adapter.project.choose;

import entities.project.Project;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import use_case.project.choose.ChooseProjectOutputBoundary;
import use_case.project.choose.ChooseProjectOutputData;

public class ChooseProjectPresenter implements ChooseProjectOutputBoundary {
    private final ChooseProjectViewModel chooseProjectViewModel;
    private final MainProjectViewModel mainProjectViewModel;
    private final ViewManagerModel viewManagerModel;

    public ChooseProjectPresenter(ChooseProjectViewModel chooseProjectViewModel, MainProjectViewModel mainProjectViewModel, ViewManagerModel viewManagerModel) {
        this.chooseProjectViewModel = chooseProjectViewModel;
        this.mainProjectViewModel = mainProjectViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareChooseSuccessView(ChooseProjectOutputData outputData) {
        ChooseProjectState state = chooseProjectViewModel.getState();
        for (Project project : outputData.getProjectList()) {
            state.setProject(project);
            chooseProjectViewModel.firePropertyChanged(ChooseProjectViewModel.UPDATE_PROJECT);
        }
    }

    @Override
    public void prepareChooseFailView(ChooseProjectOutputData outputData) {
        if (!outputData.isUseCaseFailed()) {
            return;
        }
        chooseProjectViewModel.getState().setChooseProjectError(outputData.getError());
        chooseProjectViewModel.firePropertyChanged(ChooseProjectViewModel.CHOOSE_PROJECT_ERROR);
    }

    @Override
    public void prepareEnterSuccessView(ChooseProjectOutputData outputData) {
        if (outputData.isUseCaseFailed()) {
            return;
        }
        mainProjectViewModel.getState().setProject(outputData.getChosenProject());
        mainProjectViewModel.firePropertyChanged(MainProjectViewModel.SET_PROJECT);
        viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
