package interface_adapter.project.add;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import use_case.project.add.AddProjectOutputBoundary;
import use_case.project.add.AddProjectOutputData;

public class AddProjectPresenter implements AddProjectOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AddProjectViewModel addProjectViewModel;
    private final ChooseProjectViewModel chooseProjectViewModel;

    public AddProjectPresenter(ViewManagerModel viewManagerModel, AddProjectViewModel addProjectViewModel,
                               ChooseProjectViewModel chooseProjectViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addProjectViewModel = addProjectViewModel;
        this.chooseProjectViewModel = chooseProjectViewModel;
    }

    @Override
    public void prepareSuccessView(AddProjectOutputData outputData) {
        if (outputData.useCaseFailed()) {
            return;
        }
        chooseProjectViewModel.getState().setProject(outputData.project());
        chooseProjectViewModel.firePropertyChanged(ChooseProjectViewModel.UPDATE_PROJECT);
        viewManagerModel.setActiveView(chooseProjectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(AddProjectOutputData outputData) {
        if (!outputData.useCaseFailed()) {
            return;
        }
        addProjectViewModel.getState().setAddError(outputData.error());
        addProjectViewModel.firePropertyChanged(AddProjectViewModel.ADD_PROJECT_ERROR);
    }
}
