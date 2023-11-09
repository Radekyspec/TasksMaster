package entities.project;

import entities.todo_panel.ToDoPanel;
import entities.user.User;

import java.util.HashMap;
import java.util.Map;

public class CommonProject implements Project{
    private final int ID;
    private final String name;
    private final User leader;
    private final Map<Integer, User> members;
    private final ToDoPanel toDoPanel;
    private final MessageBoard messageBoard;
    private final Schedule schedule;
    public CommonProject(int ID, String name, User leader){
        this.ID = ID;
        this.name = name;
        this.leader = leader;
        this.members = new HashMap<>();
        toDoPanel = null;
        messageBoard = null;
        schedule = null;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public User getLeader() {
        return leader;
    }

    @Override
    public Map<Integer, User> getMembers() {
        return members;
    }

    @Override
    public ToDoPanel getToDoPanel() {
        return toDoPanel;
    }

    @Override
    public MessageBoard getMessageBoard() {
        return messageBoard;
    }

    @Override
    public Schedule getSchedule() {
        return schedule;
    }

    @Override
    public void setToPanel() {

    }

    @Override
    public void setMessageBoard() {

    }

    @Override
    public void setSchedule() {

    }
}
