package use_case.todo.add;

public interface AddToDoOutputBoundary {
    void prepareSuccessView(AddToDoOutputData outputData);
    void prepareFailView(AddToDoOutputData outputData);
}
