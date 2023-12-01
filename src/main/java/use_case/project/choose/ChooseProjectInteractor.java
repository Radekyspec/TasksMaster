package use_case.project.choose;

import data_access.project.choose.ChooseProjectUserDataAccessInterface;
import entities.project.Project;

import java.util.List;

public class ChooseProjectInteractor implements ChooseProjectInputBoundary {
    private final ChooseProjectOutputBoundary presenter;
    private final ChooseProjectUserDataAccessInterface userDAO;

    public ChooseProjectInteractor(ChooseProjectOutputBoundary presenter, ChooseProjectUserDataAccessInterface userDAO) {
        this.presenter = presenter;
        this.userDAO = userDAO;
    }
    @Override
    public void execute(ChooseProjectInputData inputData) {

    }

    @Override
    public void getUserProjects(ChooseProjectInputData inputData) {
        List<Project> results = userDAO.getUserProjects(inputData.getUser());
        if (results == null) {
            ChooseProjectOutputData outputData = new ChooseProjectOutputData(results,
                    userDAO.getApiErrorMessage(),
                    true);
            presenter.prepareChooseFailView(outputData);
            return;
        }
        ChooseProjectOutputData outputData = new ChooseProjectOutputData(results, null, false);
        presenter.prepareChooseSuccessView(outputData);
    }
}
