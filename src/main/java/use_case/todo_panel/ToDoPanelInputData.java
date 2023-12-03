package use_case.todo_panel;

public class ToDoPanelInputData {
    private final long projectID;
    private final long toDoPanelID;

    public ToDoPanelInputData(long projectID, long toDoPanelID) {
        this.projectID = projectID;
        this.toDoPanelID = toDoPanelID;
    }

    public long getProjectID() {
        return projectID;
    }

    public long getToDoPanelID() {
        return toDoPanelID;
    }
}