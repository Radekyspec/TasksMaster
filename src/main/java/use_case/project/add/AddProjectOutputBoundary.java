package use_case.project.add;

public interface AddProjectOutputBoundary {
    void prepareSuccessView(AddProjectOutputData outputData);

    void prepareFailView(AddProjectOutputData outputData);
}
