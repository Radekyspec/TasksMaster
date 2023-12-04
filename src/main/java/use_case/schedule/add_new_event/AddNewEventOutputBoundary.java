package use_case.schedule.add_new_event;

public interface AddNewEventOutputBoundary {
    public void prepareSuccessView(AddNewEventOutputData addNewEventOutputData);

    public void prepareFailView();
}
