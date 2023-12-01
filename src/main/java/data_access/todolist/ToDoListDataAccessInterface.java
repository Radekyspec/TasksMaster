package data_access.todolist;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;

import java.util.Map;

public interface ToDoListDataAccessInterface {
    /**
     * Save the provided ToDoPanel to the DB.
     * when implementing, it will call method save() to persist the changes.
     * @param toDoList the organized entity that is going to store.
     */
    void save(ToDoList toDoList);

    /**
     * Verify if this Todolist is already exists.
     * @param tdlName the name of the ToDoPanel
     * @return ture or false
     */
    boolean exists(String tdlName); // what does it for?

    /**
     * The first step of import ToDoLists from the api.
     * @param ToDoPanelID corresponding ToDoPanelID. It aims at distinguish between Panels.
     * @return A map consists of all existed ToDoList in this ToDoList.
     */
    Map<Integer, ToDoList> importToDo(Integer ToDoPanelID);
}
