package use_case.project.choose;

public interface ChooseProjectOutputBoundary {
    void prepareChooseSuccessView(ChooseProjectOutputData outputData);

    void prepareChooseFailView(ChooseProjectOutputData outputData);
}
