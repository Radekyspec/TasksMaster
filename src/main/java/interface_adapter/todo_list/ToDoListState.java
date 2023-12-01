package interface_adapter.todo_list;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;

import java.util.HashMap;
import java.util.Map;

public class ToDoListState {
    /*
    Doesn't need ID here because state just receive data, it doesn't get data from api.
    Doesn't need ID in Input/Output data, because they're just passing data.
    Doesn't need ID in Controller, because controller is an activity founder, it's not a fetcher.
    Does need in ID in View/ViewModel, because execute method is used in here, which is for create.
        And about import? Maybe we do it in ViewModel? Because we don't need to show on the view.
     */
    private final Map<Integer, ToDoList> todoListPackage;
    private String toDoListError;
    private String name;
    private String workKind;

    public ToDoListState() {
        todoListPackage = null;
        toDoListError = null;
        name = null;
        workKind = null;
    }

    public String getToDoListError() {
        return toDoListError;
    }

    public void setToDoListError(String toDoListError) {
        this.toDoListError = toDoListError;
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

    public String getWorkKind() {
        return workKind;
    }

    public void setWorkKind(String workKind) {
        this.workKind = workKind;
    }

}
