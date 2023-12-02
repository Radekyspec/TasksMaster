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
    private Integer projectID;
    private Integer toDoPanelID;

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
