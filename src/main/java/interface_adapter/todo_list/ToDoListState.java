package interface_adapter.todo_list;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;

import java.util.List;

public class ToDoListState {
    /*
    Doesn't need ID here because state just receive data, it doesn't get data from api.
    Doesn't need ID in Input/Output data, because they're just passing data.
    Doesn't need ID in Controller, because controller is an activity founder, it's not a fetcher.
    Does need in ID in View/ViewModel, because execute method is used in here, which is for create.
        And about import? Maybe we do it in ViewModel? Because we don't need to show on the view.
     */
    private ToDoList newCreatedTDL;
    private String error;
    private String name;
    private final List<ToDo> listOfToDo;

    public ToDoListState() {
        error = null;
        name = null;
        newCreatedTDL = null;
        listOfToDo = null;
    }

    /**
     * The new ToDoList should send to both ToDoListState and ToDoListView.
     * It can't be merged with ListOfToDo, because soon you need to get the new lists out.
     *    1. store created ToDoList into ToDoList (it should be only One ToDoList)
     *    2. 
     * @return sth.
     */
    public ToDoList getNewCreatedTDL() {
        return newCreatedTDL;
    }

    public void setNewCreatedTDL(ToDoList newCreatedTDL) {
        this.newCreatedTDL = newCreatedTDL;
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
    public List<ToDo> getListOfToDo() {
        return listOfToDo;
    }
    public void setListOfToDo(ToDo toDo) {
        assert this.listOfToDo != null;
        this.listOfToDo.add(toDo);
    }
}
