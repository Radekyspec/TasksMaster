package interface_adapter.todo_list;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;

import java.util.HashMap;
import java.util.Map;

public class ToDoListState {
    private final Map<Integer, ToDoList> todoListPackage;
    private String toDoListError;
    private String name;

    public ToDoListState() {
        todoListPackage = new HashMap<Integer, ToDoList>();
        toDoListError = null;
        name = "";
    }

    public String getToDoListError() {
        return toDoListError;
    }

    public void setToDoListError(String toDoListError) {
        this.toDoListError = toDoListError;
    }

    public Map<Integer, ToDoList> getToDo() {
        return ;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, ToDoList> getToDoListPackage() {
        return todoListPackage;
    }

    public void setName(String name) {
        this.name = name;
    }
}
