package use_case.todo_panel;

public class ImportToDoListInputData {
    private final long projectID;
    private final long toDoPanelID;

    public ImportToDoListInputData(long projectID, long toDoPanelID) {
        this.projectID = projectID;
        this.toDoPanelID = toDoPanelID;
    }

    public long getToDoPanelID() {
        return toDoPanelID;
    }
    public long getProjectID() {
        return projectID;
    }
}
