package interface_adapter.todo_list.add;

public class AddToDoListState {
    private Integer ID;
    private String name;
    private String detail;
    private String progress;

    public AddToDoListState() {
        ID = null;
        name = null;
        detail = null;
        progress = null;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    private String ATDLSError;

}
