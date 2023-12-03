package entities.todo_panel;

public class CommonToDoPanelFactory {
    /**
     * create a CommonToDoPanel class that contains things as followed.
     *
     * @param ID the identification of this To_DoPanel
     * @return a CommonToDoPanel class
     */
    public static CommonToDoPanel create(long ID) {
        return new CommonToDoPanel(ID);
    }
}
