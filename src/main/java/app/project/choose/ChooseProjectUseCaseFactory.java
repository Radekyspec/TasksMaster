package app.project.choose;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectController;
import interface_adapter.project.choose.ChooseProjectPresenter;
import interface_adapter.project.choose.ChooseProjectViewModel;
import use_case.project.choose.ChooseProjectInputBoundary;
import use_case.project.choose.ChooseProjectInteractor;
import use_case.project.choose.ChooseProjectOutputBoundary;
import view.project.choose.ChooseProjectView;

public class ChooseProjectUseCaseFactory {
    private ChooseProjectUseCaseFactory() {}

    public static ChooseProjectView create(
            ViewManagerModel viewManagerModel, AddProjectViewModel addProjectViewModel,
            ChooseProjectViewModel chooseProjectViewModel) {
        return new ChooseProjectView(
                viewManagerModel, addProjectViewModel, chooseProjectViewModel, ChooseProjectUseCaseFactory.createController());
    }

    private static ChooseProjectController createController() {
        ChooseProjectOutputBoundary chooseProjectPresenter = new ChooseProjectPresenter();
        ChooseProjectInputBoundary interactor = new ChooseProjectInteractor(chooseProjectPresenter);
        return new ChooseProjectController(interactor);
    }
}
