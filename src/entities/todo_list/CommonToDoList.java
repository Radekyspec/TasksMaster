package entities.todo_list;

import entities.todo.ToDo;

import java.util.Map;

public class CommonToDoList implements ToDoList {
    private final int ID;
    private String name;
    private String detail;
    private Map<Integer, ToDo> toDos;

    public CommonToDoList(int ID) {
        this.ID = ID;
    }

    public int getId() {
        return ID;
    }
}
