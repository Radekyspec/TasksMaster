package entities.todo_panel;

import entities.todo_list.ToDoList;

import java.util.Map;

public class CommonToDoPanelFactory {
    /**
     * create a CommonToDoPanel class that contains things as followed.
     * @param ID the identification of this To_DoPanel
     * @param lists a list of To_DO_list it includes
     * @return a CommonToDoPanel class
     */
    public static CommonToDoPanel create(Integer ID, Map<Integer, ToDoList> lists){
        return new CommonToDoPanel(ID, lists);
    }
}
