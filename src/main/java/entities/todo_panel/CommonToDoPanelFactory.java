package entities.todo_panel;

public class CommonToDoPanelFactory {
    /**
     * Create a new to_do Panel that contain space for many to_do lists
     * @param ID the ID of the to_do Panel
     * @return a new to_do Panel object
     */
    public static CommonToDoPanel create(int ID){
        return new CommonToDoPanel(ID);
    }
}
