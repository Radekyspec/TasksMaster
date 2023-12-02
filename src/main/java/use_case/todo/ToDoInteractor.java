package use_case.todo;

public class ToDoInteractor implements ToDoInputBoundary {

    private final ToDoOutputBoundary toDoPresenter;

    public ToDoInteractor(ToDoOutputBoundary toDoPresenter) {
        this.toDoPresenter = toDoPresenter;
    }

    @Override
    public void execute(ToDoInputData toDoInputData) {
        if (toDoInputData.getWorkKind() == null) {
            ToDoOutputData outputData = new ToDoOutputData(
                    null,
                    "TDLInteractor: get failure.",
                    true,
                    null,
                    null,
                    null,
                    null);
            toDoPresenter.prepareFailView(outputData);
        } else if (toDoInputData.getWorkKind().equals("create")) {
            ToDoOutputData outputData = new ToDoOutputData(
                    "create",
                    null,
                    false,
                    toDoInputData.getTarget(),
                    toDoInputData.getAssignedTo(),
                    toDoInputData.getProgress(),
                    null);
            toDoPresenter.prepareCreateView(outputData);
        } else if (toDoInputData.getWorkKind().equals("import")) {
            ToDoOutputData outputData = new ToDoOutputData(
                    "import",
                    null,
                    false,
                    null,
                    null,
                    null,
                    toDoInputData.getToDoPackage());
            toDoPresenter.prepareImportView(outputData);
        }
    }
}
