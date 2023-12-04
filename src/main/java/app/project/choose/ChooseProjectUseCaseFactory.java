package app.project.choose;

import data_access.project.choose.ChooseProjectUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectController;
import interface_adapter.project.choose.ChooseProjectPresenter;
import interface_adapter.project.choose.ChooseProjectViewModel;
import use_case.project.choose.ChooseProjectInputBoundary;
import use_case.project.choose.ChooseProjectInteractor;
import use_case.project.choose.ChooseProjectOutputBoundary;
import view.project.choose.ChooseProjectView;

public class ChooseProjectUseCaseFactory {
    private ChooseProjectUseCaseFactory() {
    }

    public static ChooseProjectView create(
            ViewManagerModel viewManagerModel, AddProjectViewModel addProjectViewModel,
            ChooseProjectViewModel chooseProjectViewModel, MainProjectViewModel mainProjectViewModel, ChooseProjectUserDataAccessInterface userDAO) {
        return new ChooseProjectView(
                viewManagerModel, addProjectViewModel, chooseProjectViewModel,
                ChooseProjectUseCaseFactory.createController(chooseProjectViewModel, mainProjectViewModel, viewManagerModel, userDAO));
    }

    public static ChooseProjectController createController(
            ChooseProjectViewModel chooseProjectViewModel, MainProjectViewModel mainProjectViewModel, ViewManagerModel viewManagerModel, ChooseProjectUserDataAccessInterface userDAO) {
        ChooseProjectOutputBoundary chooseProjectPresenter = new ChooseProjectPresenter(chooseProjectViewModel, mainProjectViewModel, viewManagerModel);
        ChooseProjectInputBoundary interactor = new ChooseProjectInteractor(chooseProjectPresenter, userDAO);
        return new ChooseProjectController(interactor);
    }
}
