package use_case.todo_panel;

public class ToDoPanelInputData {
    private final Integer projectID;

    public ToDoPanelInputData(Integer projectID) {
        this.projectID = projectID;
    }

    public Integer getProjectID() {
        return projectID;
    }
}