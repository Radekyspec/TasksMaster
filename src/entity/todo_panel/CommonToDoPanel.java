package entity.todo_panel;

import entity.todo_list.ToDoList;

import java.util.Map;

public class CommonToDoPanel implements ToDoPanel{
    private final Integer ID;
    private final Integer LastID;
    private Map<Integer, ToDoList> lists;

    public CommonToDoPanel(Integer LastID, Map<Integer, ToDoList> lists){
        this.LastID = LastID;
        this.ID = LastID + 1;
        this.lists = lists;
    }
    
    public getToDoPanel(){
        return [ID, lists];
    }
}
