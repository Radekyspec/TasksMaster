package interface_adapter.todo_panel;

import entities.project.Project;
import entities.todo_list.ToDoList;
import entities.todo_panel.ToDoPanel;
import entities.user.User;

public class ToDoPanelState {
    private ToDoList newCreatedTDL;
    private User user;
    private Project project;
    private long projectID;
    private long toDoPanelID;
    private String importToDoListError;
    private ToDoPanel currentToDoPanel;
    private String toDoPanelError;
    public ToDoPanelState() {
        currentToDoPanel = null;
        toDoPanelError = null;
        newCreatedTDL = null;
        importToDoListError = null;
    }

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

    public String getImportToDoListError() {
        return importToDoListError;
    }

    public void setImportToDoListError(String error) {
        this.importToDoListError = error;
    }
}
