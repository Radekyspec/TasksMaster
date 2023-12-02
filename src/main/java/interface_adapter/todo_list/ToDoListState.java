package interface_adapter.todo_list;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;

import java.util.List;
import java.util.Map;

public class ToDoListState {
    /*
    Doesn't need ID here because state just receive data, it doesn't get data from api.
    Doesn't need ID in Input/Output data, because they're just passing data.
    Doesn't need ID in Controller, because controller is an activity founder, it's not a fetcher.
    Does need in ID in View/ViewModel, because execute method is used in here, which is for create.
        And about import? Maybe we do it in ViewModel? Because we don't need to show on the view.
     */
    private ToDoList toDoList;
    private String error;
    private String name;
    private final List<ToDo> listOfToDo;

    public ToDoListState() {
        error = null;
        name = null;
        toDoList = null;
        listOfToDo = null;
    }



    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
    public ToDoList getToDoList() {
        return toDoList;
    }

    public List<ToDo> getListOfToDo() {
        return listOfToDo;
    }

    public void setListOfToDo(ToDo toDo) {
        this.listOfToDo.add(toDo);
    }
}
