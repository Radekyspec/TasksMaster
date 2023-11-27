package entities.todo_panel;

import entities.todo_list.ToDoList;

import java.util.HashMap;
import java.util.Map;

public class CommonToDoPanel implements ToDoPanel{
    private final Integer ID;
    private final Map<Integer, ToDoList> toDoLists;

    /**
     * build a new to_do Panel that contain space for many to_do lists
     * @param ID the ID of the to_do Panel
     */
    public CommonToDoPanel(int ID){
        this.ID = ID;
        toDoLists = new HashMap<>();
    }

    /**
     * Return the ID of the to_do panel
     *
     * @return its ID
     */
    @Override
    public int getID() {
        return ID;
    }

    /**
     * Return the to_do lists of the to_do panel
     *
     * @return a to_do lists of the current to_do panel
     */
    @Override
    public Map<Integer, ToDoList> getToDoLists() {
        return toDoLists;
    }

    /**
     * add a new to_do list into the to_do panel
     * @param toDoList the new to_do list
     */
    @Override
    public void setToDoLists(ToDoList toDoList) {
        toDoLists.put(toDoList.getId(), toDoList);
    }
}
