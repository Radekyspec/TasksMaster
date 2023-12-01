package use_case.todo_list;

import interface_adapter.todo_list.ToDoListPresenter;

public class ToDoListInteractor implements ToDoListInputBoundary{
    private final ToDoListOutputBoundary toDoListPresenter;

    public ToDoListInteractor(ToDoListOutputBoundary toDoListPresenter) {
        this.toDoListPresenter = toDoListPresenter;
    }
    @Override
    public void execute(ToDoListInputData toDoListInputData) {
        if (toDoListInputData.getWorkKind() == null) {
            ToDoListOutputData outputData = new ToDoListOutputData(
                    null,
                    "TDLInteractor: get failure.",
                    true,
                    null,
                    null,
                    null,
                    null);
            toDoListPresenter.prepareFailView(outputData);
        } else if (toDoListInputData.getWorkKind().equals("create")) {
            ToDoListOutputData outputData = new ToDoListOutputData(
                    "create",
                    null,
                    false,
                    toDoListInputData.getID(),
                    toDoListInputData.getName(),
                    toDoListInputData.getDetail(),
                    null);
            toDoListPresenter.prepareCreateView(outputData);
        } else if (toDoListInputData.getWorkKind().equals("import")) {
            ToDoListOutputData outputData = new ToDoListOutputData(
                    "import",
                    null,
                    false,
                    null,
                    null,
                    null,
                    toDoListInputData.getToDoListPackage());
            toDoListPresenter.prepareImportView(outputData);
        }
    }
}
