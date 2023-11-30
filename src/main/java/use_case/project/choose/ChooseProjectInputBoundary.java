package use_case.project.choose;

public interface ChooseProjectInputBoundary {
    void execute(ChooseProjectInputData inputData);

    void getUserProjects(ChooseProjectInputData inputData);
}
