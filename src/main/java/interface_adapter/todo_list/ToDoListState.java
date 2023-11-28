package interface_adapter.todo_list;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;

import java.util.HashMap;
import java.util.Map;

public class ToDoListState {
    private final Map<Integer, ToDo> toDos;
    private String toDoListError;

    public ToDoListState() {
        toDoLists = new HashMap<>();
        toDoListError = null;
    }

    public String getToDoListError() {
        return toDoListError;
    }

    public void setToDoListError(String toDoListError) {
        this.toDoListError = toDoListError;
    }

    public Map<Integer, ToDoList> getToDoLists() {
        return toDoLists;
    }
}
