package interface_adapter.project.add;

import entities.user.User;
import use_case.project.add.AddProjectInputBoundary;
import use_case.project.add.AddProjectInputData;

public class AddProjectController {
    private final AddProjectInputBoundary interactor;

    public AddProjectController(AddProjectInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(User user, String name, String description) {
        interactor.execute(new AddProjectInputData(user, name, description));
    }
}
