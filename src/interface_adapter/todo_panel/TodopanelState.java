package interface_adapter.todo_panel;

import entities.todo_list.ToDoList;

public class TodopanelState {
    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    private ToDoList toDoList;
}
