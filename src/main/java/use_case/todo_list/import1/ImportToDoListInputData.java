package use_case.todo_list.import1;

public class ImportToDoListInputData {
    private final Integer projectID;
    private final Integer toDoPanelID;

    public ImportToDoListInputData(Integer projectID, Integer toDoPanelID) {
        this.projectID = projectID;
        this.toDoPanelID = toDoPanelID;
    }

    public Integer getToDoPanelID() {
        return toDoPanelID;
    }
    public Integer getProjectID() {
        return projectID;
    }
}
