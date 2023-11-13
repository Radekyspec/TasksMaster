package entities.todo_list;

import entities.todo.ToDo;
import java.util.Map;

public class CommonToDoList implements ToDoList{
    private final Integer ID;
    private String name;
    private String detail;
    private Map<Integer, ToDo> toDos;

    public CommonToDoList(Integer LastID, String name, String detail,
                          Map<Integer, ToDo> toDos){
        this.ID = LastID + 1; // No detect of ID < 0
        this.name = name;
        this.detail = detail;
        this.toDos = toDos;
    }

    /**
     * Returns this To_DoList object, which pack this to_doList in a whole.
     * Comparing to return a hashmap, it eliminates further modifications.
     * @return a To_DoList object.
     */
    @Override
    public ToDoList getToDoList(){
        return this;
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
}
