package interface_adapter.todo_list.add;

public class AddToDoListState {
    private Integer listID;
    private String name;
    private String detail;

    public AddToDoListState() {
        listID = null;
        name = null;
        detail = null;
    }

    public Integer getListID() {
        return listID;
    }

    public void setListID(Integer listID) {
        this.listID = listID;
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
