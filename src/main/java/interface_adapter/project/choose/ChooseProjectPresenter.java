package interface_adapter.project.choose;

import entities.project.Project;
import use_case.project.choose.ChooseProjectOutputBoundary;
import use_case.project.choose.ChooseProjectOutputData;

public class ChooseProjectPresenter implements ChooseProjectOutputBoundary {
    private final ChooseProjectViewModel chooseProjectViewModel;

    public ChooseProjectPresenter(ChooseProjectViewModel chooseProjectViewModel) {
        this.chooseProjectViewModel = chooseProjectViewModel;
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
}
