package interface_adapter.todo_panel;

import entities.todo_list.ToDoList;

/**
 * a state class that solely for todolist panel
 * The state itself is the message that a
 */
public class ToDoPanelState {

    /**
     * Return the set todolist
     * @return state that passed in
     */
    public ToDoList getToDoList() {
        return toDoList;
    }

    /**
     * Set a todolist and preparing to pass it.
     * @param toDoList set the current todolist into the todolist passed in.
     */
    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    private ToDoList toDoList;
}
