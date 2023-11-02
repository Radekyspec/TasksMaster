package entities.todo_list;

import entities.todo.ToDo;

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
