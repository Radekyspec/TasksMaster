package entities.todo_list;

import entities.todo.ToDo;

import java.util.Map;

public interface ToDoList {
    ToDoList getToDoList();
    Integer getId();
    String getName();
    String getDetail();
    Map<Integer, ToDo> getToDos();
}