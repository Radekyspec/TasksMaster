package entities.todo_panel;

import entities.todo_list.ToDoList;

import java.util.Map;

public interface ToDoPanel {
    ToDoPanel getToDoPanel();
    Integer getId();
    Map<Integer, ToDoList> getLists();
}
