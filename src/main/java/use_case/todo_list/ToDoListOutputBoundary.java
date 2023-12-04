package use_case.todo_list;

public interface ToDoListOutputBoundary {
    /**
     * namely
     *
     * @param toDoListOutputData get output data from Interactor ONLY.
     */
    void prepareFailView(ToDoListOutputData toDoListOutputData);

    /**
     * namely
     *
     * @param toDoListOutputData get output data from Interactor ONLY.
     */
    void prepareImportView(ToDoListOutputData toDoListOutputData);
}
