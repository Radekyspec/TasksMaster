package entities.todo_list;

import entities.todo.ToDo;

import java.util.Map;

public interface ToDoList {
    /**
     * Returns ID of this obj.
     * @return its ID.
     */
    Integer getId();

    /**
     * Returns name of this obj.
     * @return its name.
     */
    String getName();

    /**
     * Returns detail of this obj.
     * A brief description of this TO_DoList
     * @return its detail.
     */
    String getDetail();

    /**
     * Returns toDos of this obj.
     * A Map contains pairs of (ID of TO_DO, TO_DO)
     * @return A map contains pairs of id and to_do.
     */
    Map<Integer, ToDo> getToDos();

    /**
     * add a new to_do into the to_do list
     * @param toDo a new to_do
     */
    void addToDos(ToDo toDo);
}