package entities.todo_panel;

import entities.todo_list.ToDoList;

import java.util.Map;

public interface ToDoPanel {
    /**
     * Return the ID of the to_do panel
     *
     * @return its ID
     */
    int getID();

    /**
     * Return the to_do lists of the to_do panel
     *
     * @return a to_do lists of the current to_do panel
     */
    Map<Integer, ToDoList> getToDoLists();

    /**
     * add a new to_do list into the to_do panel
     * @param toDoList the new to_do list
     */
    void setToDoLists(ToDoList toDoList);
}
