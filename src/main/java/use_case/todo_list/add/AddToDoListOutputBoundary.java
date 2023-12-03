package use_case.todo_list.add;

public interface AddToDoListOutputBoundary {
    void prepareSuccessView(AddToDoListOutputData outputData);
    void prepareFailView(AddToDoListOutputData outputData);
}
