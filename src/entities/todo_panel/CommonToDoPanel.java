package entities.todo_panel;

import entities.todo_list.ToDoList;
import java.util.Map;
import java.util.HashMap;

public class CommonToDoPanel implements ToDoPanel{
    private final Integer ID;
    private final Integer LastID;
    private Map<Integer, ToDoList> lists;

    public CommonToDoPanel(Integer LastID, Map<Integer, ToDoList> lists){
        this.LastID = LastID;
        this.ID = LastID + 1;
        this.lists = lists;
    }

    @Override
    public Map<String, Object> getToDoPanel(){
        Map<String, Object> tdpM = new HashMap<>(); //Object and Objects are NOT the same.
        tdpM.put("ID", ID);
        tdpM.put("lists", lists);
        return tdpM;
    }
}
