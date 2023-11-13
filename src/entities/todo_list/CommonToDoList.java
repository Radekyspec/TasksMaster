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

    public int getId() {
        return ID;
    }
}
