package use_case.todo_list;

import interface_adapter.todo_list.ToDoListPresenter;

public class ToDoListInteractor implements ToDoListInputBoundary{
    private final ToDoListOutputBoundary toDoListPresenter;

    public ToDoListInteractor(ToDoListOutputBoundary toDoListPresenter) {
        this.toDoListPresenter = toDoListPresenter;
    }
    @Override
    public void execute(ToDoListInputData toDoListInputData) {
        ToDoListInputData TDLInputData = toDoListInputData;
        if (TDLInputData.getWorkKind() == null) {
            ToDoListOutputData outputData = new ToDoListOutputData(
                    "TDLInteractor: get failure.",
                    true,
                    null,
                    null,
                    null,
                    null);
            toDoListPresenter.prepareFailView(outputData);
        } else if (TDLInputData.getWorkKind().equals("create")) {
            ToDoListOutputData outputData = new ToDoListOutputData(
                    null,
                    false,
                    TDLInputData.getID(),
                    TDLInputData.getName(),
                    TDLInputData.getDetail(),
                    null);
            toDoListPresenter.prepareCreateView(outputData);
        } else if (TDLInputData.getWorkKind().equals("import")) {
            ToDoListOutputData outputData = new ToDoListOutputData(
                    null,
                    false,
                    null,
                    null,
                    null,
                    TDLInputData.getToDoListPackage());
            toDoListPresenter.prepareImportView(outputData);
        }
    }
}
