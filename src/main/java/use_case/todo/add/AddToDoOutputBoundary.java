package use_case.todo.add;

import use_case.todo_list.add.AddToDoListOutputData;

public interface AddToDoOutputBoundary {
    void prepareSuccessView(AddToDoOutputData outputData);
    void prepareFailView(AddToDoOutputData outputData);
}
