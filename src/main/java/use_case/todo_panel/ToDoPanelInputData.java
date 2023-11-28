package use_case.todo_panel;
import entities.todo_list.ToDoList;

public class ToDoPanelInputData {
    // private final String[toDos] tdpContent;
    private final String ID;
    private final String ProjectID;

    public ToDoPanelInputData(String ID, String ProjectID) {
        this.ID = ID;
        this.ProjectID = ProjectID;
    }

    /**
     *
     * @return ID.
     */
    public String getID() {
        return ID;
    }

    /**
     *
     * @return ProjectID.
     */
    public String getProjectID() {
        return ProjectID;
    }
}