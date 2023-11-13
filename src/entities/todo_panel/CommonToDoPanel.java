package entities.todo_panel;

import entities.todo_list.ToDoList;
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

    /**
     * Returns this To_DoPanel object, which pack this to_doPanel in a whole.
     * Comparing to return a hashmap, it eliminates further modifications.
     * @return a To_DoPanel object.
     */
    @Override
    public ToDoPanel getToDoPanel(){
        return this;
    }
}
