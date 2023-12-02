package use_case.todo_list.add;

public class AddToDoListInputData {
    private final String name;
    private final String detail;
    private final Integer listID;

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

    public Integer getListID() {
        return listID;
    }

    public AddToDoListInputData(String name, String detail, Integer listID, Integer projectID) {
        this.name = name;
        this.detail = detail;
        this.listID = listID;
        this.projectID = projectID;
    }
}
