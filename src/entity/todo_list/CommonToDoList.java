package entity.todo_list;

import entity.todo.ToDo;

import java.util.Map;

public class CommonToDoList implements ToDoList{
    private Integer ID;
    private String name;
    private String detail;
    private Map<Integer, ToDo> toDos;

    public CommonToDoList(Integer ID){
        this.ID = ID;
    }
}
