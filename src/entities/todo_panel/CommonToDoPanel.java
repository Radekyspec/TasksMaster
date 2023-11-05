package entities.todo_panel;

import entities.todo_list.ToDoList;

import java.util.Map;

public class CommonToDoPanel implements ToDoPanel {
    private final Integer ID; // ID不添加final,因为需要靠传入来获得id。
    private Map<Integer, ToDoList> lists;

    public CommonToDoPanel(Integer ID) {
        this.ID = ID;
    }
}
