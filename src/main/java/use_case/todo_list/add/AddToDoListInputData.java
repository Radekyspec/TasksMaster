package use_case.todo_list.add;

public class AddToDoListInputData {
    private final String name;
    private final String detail;
    private final Integer panelID;

    public Integer getProjectID() {
        return projectID;
    }

    private final Integer projectID;

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public Integer getPanelID() {
        return panelID;
    }

    public AddToDoListInputData(String name, String detail, Integer listID, Integer projectID) {
        this.name = name;
        this.detail = detail;
        this.panelID = listID;
        this.projectID = projectID;
    }
}
