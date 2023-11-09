package entities.todo_list;

import entities.todo.ToDo;
import java.util.Map;
import java.util.HashMap;

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
    
    @Override
    public Map<String, Object> getToDoList(){
        Map<String, Object> tdlMap = new HashMap<>();
        tdlMap.put("ID", ID);
        tdlMap.put("name", name);
        tdlMap.put("detail", detail);
        tdlMap.put("toDos", toDos);
        return tdlMap;
    }
}
