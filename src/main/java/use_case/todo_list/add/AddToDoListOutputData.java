package use_case.todo_list.add;

import entities.todo_list.ToDoList;

public class AddToDoListOutputData {


    private final ToDoList toDoList;
    private final String error;
    private final boolean useCaseFailed;

    public AddToDoListOutputData(ToDoList toDoList, String error, boolean useCaseFailed) {
        this.toDoList = toDoList;
        this.error = error;
        this.useCaseFailed = useCaseFailed;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public String getError() {
        return error;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
