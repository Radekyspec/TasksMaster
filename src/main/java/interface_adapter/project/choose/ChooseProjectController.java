package interface_adapter.project.choose;

import entities.project.Project;
import entities.user.User;
import use_case.project.choose.ChooseProjectInputBoundary;
import use_case.project.choose.ChooseProjectInputData;

public class ChooseProjectController {
    private final ChooseProjectInputBoundary interactor;

    public ChooseProjectController(ChooseProjectInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(Project project) {
        ChooseProjectInputData inputData = new ChooseProjectInputData(project);
        interactor.execute(inputData);
    }

    public void getUserProjects(User user) {
        ChooseProjectInputData inputData = new ChooseProjectInputData(user);
        interactor.getUserProjects(inputData);
    }
}
