package use_case.todo.add;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;

public class AddToDoOutputData {
    private final ToDo toDo;
    private final String error;
    private final boolean useCaseFailed;

    public AddToDoOutputData(ToDo toDo, String error, boolean useCaseFailed) {
        this.toDo = toDo;
        this.error = error;
        this.useCaseFailed = useCaseFailed;
    }

    public ToDo getToDo() {
        return toDo;
    }

    public String getError() {
        return error;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
