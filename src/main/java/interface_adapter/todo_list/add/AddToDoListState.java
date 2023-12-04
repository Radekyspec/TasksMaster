package interface_adapter.todo_list.add;

public class AddToDoListState {
    private long projectID;
    private long toDoPanelID;
    private String name;
    private String detail;
    private String ATDLSError;

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public long getToDoPanelID() {
        return toDoPanelID;
    }

    public void setToDoPanelID(long toDoPanelID) {
        this.toDoPanelID = toDoPanelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getATDLSError() {
        return ATDLSError;
    }

    public void setATDLSError(String ATDLSError) {
        this.ATDLSError = ATDLSError;
    }

}
