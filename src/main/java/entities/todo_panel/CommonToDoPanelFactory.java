package entities.todo_panel;

import entities.todo_list.ToDoList;

import java.util.Map;

public class CommonToDoPanelFactory {
    /**
     * create a CommonToDoPanel class that contains things as followed.
     * @param ID the identification of this To_DoPanel
     * @return a CommonToDoPanel class
     */
    public static CommonToDoPanel create(Integer ID){
        return new CommonToDoPanel(ID);
    }
}
