package interface_adapter.project.add_people;

import entities.project.Project;
import use_case.project.add_people.AddPeopleInputBoundary;
import use_case.project.add_people.AddPeopleInputData;

public class AddPeopleController {
    final AddPeopleInputBoundary addPeopleInteractor;

    public AddPeopleController(AddPeopleInputBoundary addPeopleInteractor) {
        this.addPeopleInteractor = addPeopleInteractor;
    }

    public void execute(String username, Project project) {
        AddPeopleInputData addPeopleInputData = new AddPeopleInputData(username, project);
        addPeopleInteractor.execute(addPeopleInputData);
    }
}
