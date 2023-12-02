package use_case.project.add_people;

public interface AddPeopleOutputBoundary {
    void prepareFailView();

    void prepareSuccessView(AddPeopleOutputData addPeopleOutputData);
}
