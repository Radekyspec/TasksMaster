package interface_adapter.todo;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;

import java.util.HashMap;
import java.util.Map;

public class ToDoState {
    private String toDoError;

    public ToDoState() {
        toDoError = null;
    }

    public String getToDoError() {
        return toDoError;
    }

    public void setToDoError(String toDoError) {
        this.toDoError = toDoError;
    }

    public Map<Integer, ToDoList> getToDos() {
        return toDos;
    }
}
