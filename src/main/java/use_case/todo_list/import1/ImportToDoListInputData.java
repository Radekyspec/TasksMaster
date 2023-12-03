package use_case.todo_list.import1;

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
