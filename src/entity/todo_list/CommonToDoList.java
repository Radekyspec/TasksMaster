package entity.todo_list;

import entity.todo.ToDo;

import java.util.Map;

public class CommonToDoList implements ToDoList{
    private final Integer ID;
    private final Integer LastID;
    private String name;
    private String detail;
    private Map<Integer, ToDo> toDos;

    public CommonToDoList(Integer LastID, String name, String detail,
                          Map<Integer, ToDo> toDos){
        this.LastID = LastID;
        this.ID = LastID + 1; // No detect of ID < 0
        this.name = name;
        this.detail = detail;
        this.toDos = toDos;
    }
    
    @Override
    public getToDoList(){
        return [ID, name, detail, toDos]; 
    }
}
