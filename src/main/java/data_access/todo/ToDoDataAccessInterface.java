package data_access.todo;

import entities.todo.ToDo;

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
}
