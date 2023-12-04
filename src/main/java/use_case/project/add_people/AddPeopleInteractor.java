package use_case.project.add_people;

import data_access.project.ProjectUserDataAccessInterface;
import entities.project.Project;

public class AddPeopleInteractor implements AddPeopleInputBoundary {
    final AddPeopleOutputBoundary addPeoplePresenter;
    final ProjectUserDataAccessInterface dataAccessInterface;

    public AddPeopleInteractor(AddPeopleOutputBoundary addPeoplePresenter, ProjectUserDataAccessInterface dataAccessInterface) {
        this.addPeoplePresenter = addPeoplePresenter;
        this.dataAccessInterface = dataAccessInterface;
    }

    final
    @Override
    public void execute(AddPeopleInputData addPeopleInputData) {
        String username = addPeopleInputData.username();
        Project project = addPeopleInputData.project();
        if (dataAccessInterface.exists(username, project)) {
            addPeoplePresenter.prepareFailView();
        } else {
            dataAccessInterface.addProjectMember(project, username);
            project.addNewMember(username);
            AddPeopleOutputData addPeopleOutputData = new AddPeopleOutputData(project);
            addPeoplePresenter.prepareSuccessView(addPeopleOutputData);
        }
    }
}
