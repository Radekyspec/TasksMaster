package use_case.todo_list;

import entities.todo.ToDo;

public class ToDoListOutputData {
    private final boolean useCaseFailed;
    private final ToDo toDo;
    private final String error;

    /**
     * Standard todolist output data.
     * We pass to_do as a To_Do object because we will get the detail info at ToDoListView.
     *
     * @param useCaseFailed boolean, is use case failed.
     * @param error         Namely, if applicable.
     */

    public ToDoListOutputData(boolean useCaseFailed, String error,
                              ToDo toDo) {
        this.error = error;
        this.useCaseFailed = useCaseFailed;
        this.toDo = toDo;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
    public String getError() {
        return error;
    }
    public ToDo getToDo() {
        return toDo;
    }
}
