package use_case.todo_list;

import entities.todo.ToDo;

import java.util.List;

public record ToDoListOutputData(boolean useCaseFailed, String error, List<ToDo> listOfToDo) {
    /**
     * Standard todolist output data.
     * We pass to_do as a To_Do object because we will get the detail info at ToDoListView.
     *
     * @param useCaseFailed boolean, is use case failed.
     * @param error         Namely, if applicable.
     */

    public ToDoListOutputData {
    }
}
