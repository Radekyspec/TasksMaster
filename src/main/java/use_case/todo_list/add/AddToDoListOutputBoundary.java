package use_case.todo_list.add;

import use_case.project.add.AddProjectOutputData;

public interface AddToDoListOutputBoundary {
    void prepareSuccessView(AddToDoListOutputData outputData);
    void prepareFailView(AddToDoListOutputData outputData);
}
