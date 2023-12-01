package use_case.project.choose;

public class ChooseProjectInteractor implements ChooseProjectInputBoundary {
    private final ChooseProjectOutputBoundary presenter;

    public ChooseProjectInteractor(ChooseProjectOutputBoundary presenter) {
        this.presenter = presenter;
    }
    @Override
    public void execute(ChooseProjectInputData inputData) {

    }

    @Override
    public void getUserProjects(ChooseProjectInputData inputData) {

    }
}
