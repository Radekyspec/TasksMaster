package entities.project;

import entities.message_board.MessageBoard;
import entities.schedule.Schedule;
import entities.todo_panel.ToDoPanel;
import entities.user.User;

import java.util.HashMap;
import java.util.Map;

public class CommonProject implements Project {
    private final int ID;
    private final String name;
    private final User leader;
    private final Map<Integer, User> members;
    private ToDoPanel toDoPanel;
    private MessageBoard messageBoard;
    private Schedule schedule;

    public CommonProject(int ID, String name, User leader) {
        this.ID = ID;
        this.name = name;
        this.leader = leader;
        this.members = new HashMap<>();
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

    /**
     * Set the to_do panel as current to_do panel for the project
     * @param toDoPanel a to_do panel object
     */
    @Override
    public void setToDoPanel(ToDoPanel toDoPanel) {
        this.toDoPanel = toDoPanel;
    }

    @Override
    public void setMessageBoard(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    @Override
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
