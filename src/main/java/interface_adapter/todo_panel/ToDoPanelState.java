package interface_adapter.todo_panel;

import entities.project.Project;
import entities.todo_list.ToDoList;
import entities.todo_panel.ToDoPanel;
import entities.user.User;

import java.util.List;

public class ToDoPanelState {
    private final List<ToDoList> listOfToDoList;
    private ToDoList newCreatedTDL;
    private User user;
    private Project project;
    private Integer projectID; // 用于承接传入的ID，ToDo 记得接收这个ID
    private Integer toDoPanelID; // 用于承接传入的ID，ToDo 记得接收这个ID

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public Integer getToDoPanelID() {
        return toDoPanelID;
    }

    public void setToDoPanelID(Integer toDoPanelID) {
        this.toDoPanelID = toDoPanelID;
    }

    public List<ToDoList> getListOfToDoList() {
        return listOfToDoList;
    }

    public void setListOfToDoList(ToDoList toDoList) {
        assert this.listOfToDoList != null;
        this.listOfToDoList.add(toDoList);
    }

    private ToDoPanel currentToDoPanel;
    private String toDoPanelError;

    public ToDoPanelState() {
        currentToDoPanel = null;
        toDoPanelError = null;
        newCreatedTDL = null;
        listOfToDoList = null;
    }

    public ToDoList getNewCreatedTDL() {
        return newCreatedTDL;
    }

    public void setNewCreatedTDL(ToDoList newCreatedTDL) {
        this.newCreatedTDL = newCreatedTDL;
    }

    public String getToDoPanelError() {
        return toDoPanelError;
    }

    public void setToDoPanelError(String toDoPanelError) {
        this.toDoPanelError = toDoPanelError;
    }

    public ToDoPanel getCurrentToDoPanel() {
        return currentToDoPanel;
    }

    public void setCurrentToDoPanel(ToDoPanel currentToDoPanel) {
        this.currentToDoPanel = currentToDoPanel;
    }
}
