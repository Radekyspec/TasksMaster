package entities.todo_list;

import entities.todo.ToDo;

import java.util.HashMap;
import java.util.Map;

public class CommonToDoList implements ToDoList {
    private final long listID;
    private final long projectID;
    private final String name;
    private final String detail;
    private final Map<Long, ToDo> toDos;


    /**
     * build up a to_do list
     *
     * @param listID    the listID
     * @param projectID the projectID
     * @param name      the name
     * @param detail    the detail
     */
    public CommonToDoList(long listID, long projectID, String name, String detail) {
        this.listID = listID;
        this.projectID = projectID;
        this.name = name;
        this.detail = detail;
        toDos = new HashMap<>();
    }

    /**
     * Returns listID of this obj.
     *
     * @return its listID.
     */
    @Override
    public long getListID() {
        return this.listID;
    }

    /**
     * Returns name of this obj.
     *
     * @return its name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns detail of this obj.
     * A brief description of this TO_DoList
     *
     * @return its detail.
     */
    @Override
    public String getDetail() {
        return this.detail;
    }

    /**
     * Returns toDos of this obj.
     * A Map contains pairs of (listID of TO_DO, TO_DO)
     *
     * @return A map contains pairs of id and to_do.
     */
    @Override
    public Map<Long, ToDo> getToDos() {
        return this.toDos;
    }

    /**
     * add a new to_do into the to_do list
     */
    @Override
    public void addToDos(ToDo toDo) {
        toDos.put(toDo.getID(), toDo);
    }

    @Override
    public long getProjectID() {
        return projectID;
    }
}