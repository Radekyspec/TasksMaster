package use_case.project.add;

import data_access.project.add.AddProjectUserDataAccessInterface;
import entities.project.Project;

public class AddProjectInteractor implements AddProjectInputBoundary {
    private final AddProjectOutputBoundary presenter;
    private final AddProjectUserDataAccessInterface userDAO;

    public AddProjectInteractor(AddProjectOutputBoundary presenter, AddProjectUserDataAccessInterface userDAO) {
        this.presenter = presenter;
        this.userDAO = userDAO;
    }

    @Override
    public void execute(AddProjectInputData inputData) {
        Project project = userDAO.createProject(
                inputData.getUser(), inputData.getName(), inputData.getDescription()
        );
        if (project == null) {
            AddProjectOutputData outputData = new AddProjectOutputData(
                    null, userDAO.getApiErrorMessage(), true);
            presenter.prepareFailView(outputData);
            return;
        }
        AddProjectOutputData outputData = new AddProjectOutputData(
                project, null, false
        );
        presenter.prepareSuccessView(outputData);
    }
}
