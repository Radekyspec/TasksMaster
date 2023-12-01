package app.project.add;

import data_access.project.add.AddProjectUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.add.AddProjectController;
import interface_adapter.project.add.AddProjectPresenter;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import use_case.project.add.AddProjectInputBoundary;
import use_case.project.add.AddProjectInteractor;
import use_case.project.add.AddProjectOutputBoundary;
import view.project.add.AddProjectView;

public class AddProjectUseCaseFactory {
    private AddProjectUseCaseFactory() {}

    public static AddProjectView create(
            ViewManagerModel viewManagerModel, AddProjectViewModel addProjectViewModel,
            ChooseProjectViewModel chooseProjectViewModel, AddProjectUserDataAccessInterface userDAO) {
        return new AddProjectView(
                viewManagerModel, addProjectViewModel, createController(
                        viewManagerModel, addProjectViewModel, chooseProjectViewModel, userDAO), chooseProjectViewModel
        );
    }

    public static AddProjectController createController(
            ViewManagerModel viewManagerModel, AddProjectViewModel addProjectViewModel,
            ChooseProjectViewModel chooseProjectViewModel, AddProjectUserDataAccessInterface userDAO
    ) {
        AddProjectOutputBoundary presenter = new AddProjectPresenter(
                viewManagerModel, addProjectViewModel, chooseProjectViewModel);
        AddProjectInputBoundary interactor = new AddProjectInteractor(presenter, userDAO);
        return new AddProjectController(interactor);
    }
}
