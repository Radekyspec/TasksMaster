package use_case.todo;

public interface ToDoOutputBoundary {
    /**
     * namely
     * @param toDoOutputData get output data from Interactor ONLY.
     */
    void prepareFailView(ToDoOutputData toDoOutputData);

    /**
     * namely
     * @param toDoOutputData get output data from Interactor ONLY.
     */
    void prepareCreateView(ToDoOutputData toDoOutputData);

    /**
     * namely
     * @param toDoOutputData get output data from Interactor ONLY.
     */
    void prepareImportView(ToDoOutputData toDoOutputData);
}
