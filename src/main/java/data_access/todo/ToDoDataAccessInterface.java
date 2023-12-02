package data_access.todo;

import entities.todo.ToDo;

import java.util.Map;

public interface ToDoDataAccessInterface {
    /*
    /**
     * Verify if this ToDoPanel is already exists.
     * @param toDoName the name of the To_Do.
     * @return ture or false

    boolean exists(String toDoName);
    */

    /**
     * Save the provided ToDoPanel to the DB.
     * when implementing, it will call method save() to persist the changes.
     * @param toDo the organized entity that is going to store.
     */
    void save(ToDo toDo);

    /**
     * The first step of import ToDos from the api.
     * @param ToDoListID corresponding ToDoListID. It aims at distinguish between Lists.
     * @return A map consists of all existed To_Do In this ToDoList.
     */
    Map<Integer, ToDo> importToDo(Integer ToDoListID);
}
