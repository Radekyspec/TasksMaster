package entities.todo_list;

import entities.todo.ToDo;

import java.util.HashMap;
import java.util.Map;

public class CommonToDoList implements ToDoList{
    private final Integer ID;
    private final String name;
    private final String detail;
    private final Map<Integer, ToDo> toDos;

    public CommonToDoList(Integer ID, String name, String detail){
        this.ID = ID;
        this.name = name;
        this.detail = detail;
        toDos = new HashMap<>();
    }

    /**
     * Returns ID of this obj.
     * @return its ID.
     */
    @Override
    public Integer getId() {
        return this.ID;
    }

    /**
     * Returns name of this obj.
     * @return its name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns detail of this obj.
     * A brief description of this TO_DoList
     * @return its detail.
     */
    @Override
    public String getDetail() {
        return this.detail;
    }

    /**
     * Returns toDos of this obj.
     * A Map contains pairs of (ID of TO_DO, TO_DO)
     * @return A map contains pairs of id and to_do.
     */
    @Override
    public Map<Integer, ToDo> getToDos() {
        return this.toDos;
    }
    /**
     * add a new to_do into the to_do list
     *
     * @param toDo a new todo
     */
    @Override
    public void addToDos(ToDo toDo) {
        toDos.put(toDo.getId(), toDo);
    }
}