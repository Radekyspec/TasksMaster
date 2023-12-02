package use_case.todo_list.add;

import use_case.project.add.AddProjectInputData;

public class AddToDoListInputData {
    private final String name;
    private final String detail;
    private final Integer ID;

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public Integer getID() {
        return ID;
    }

    public AddToDoListInputData(String name, String detail, Integer ID) {
        this.name = name;
        this.detail = detail;
        this.ID = ID;
    }
}
