package app.project.add_people;

import data_access.project.ProjectUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add_people.AddPeopleController;
import interface_adapter.project.add_people.AddPeoplePresenter;
import interface_adapter.project.add_people.AddPeopleViewModel;
import use_case.project.add_people.AddPeopleInputBoundary;
import use_case.project.add_people.AddPeopleInteractor;
import use_case.project.add_people.AddPeopleOutputBoundary;
import view.project.add_people.AddPeopleView;

public class AddPeopleUseCaseFactory {
    private AddPeopleUseCaseFactory() {
    }

    public static AddPeopleView create(ViewManagerModel viewManagerModel, AddPeopleViewModel addPeopleViewModel, MainProjectViewModel mainProjectViewModel, ProjectUserDataAccessInterface projectUserDataAccessInterface) {
        return new AddPeopleView(viewManagerModel, addPeopleViewModel, mainProjectViewModel, AddPeopleUseCaseFactory.createController(viewManagerModel, mainProjectViewModel, projectUserDataAccessInterface));
    }

    public static AddPeopleController createController(ViewManagerModel viewManagerModel, MainProjectViewModel mainProjectViewModel, ProjectUserDataAccessInterface projectUserDataAccessInterface) {
        AddPeopleOutputBoundary addPeoplePresenter = new AddPeoplePresenter(viewManagerModel, mainProjectViewModel);
        AddPeopleInputBoundary addPeopleInteractor = new AddPeopleInteractor(addPeoplePresenter, projectUserDataAccessInterface);
        return new AddPeopleController(addPeopleInteractor);
    }
}
