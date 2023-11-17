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

    /**
     * build a CommonProject object.
     * @param ID the ID of the project
     * @param name the name of the project
     * @param leader the leader of the project
     */
    public CommonProject(int ID, String name, User leader) {
        this.ID = ID;
        this.name = name;
        this.leader = leader;
        this.members = new HashMap<>();
    }

    /**
     * Return the ID of the Project
     *
     * @return its ID
     */
    @Override
    public int getID() {
        return ID;
    }

    /**
     * Return the name of the Project
     *
     * @return its name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Return the leader of the Project
     *
     * @return its leader
     */
    @Override
    public User getLeader() {
        return leader;
    }

    /**
     * Return all members of the Project
     *
     * @return its members
     */
    @Override
    public Map<Integer, User> getMembers() {
        return members;
    }

    /**
     * Return the to_do panel of the Project
     *
     * @return a to_do panel of the current project
     */
    @Override
    public ToDoPanel getToDoPanel() {
        return toDoPanel;
    }

    /**
     * Return the MessageBoard of the Project
     *
     * @return a message_board of the current project
     */
    @Override
    public MessageBoard getMessageBoard() {
        return messageBoard;
    }

    /**
     * Return the schedule of the Project
     *
     * @return a schedule of the current project
     */
    @Override
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Set the to_do panel as current to_do panel for the project
     *
     * @param toDoPanel a to_do panel object
     */
    @Override
    public void setToDoPanel(ToDoPanel toDoPanel) {
        this.toDoPanel = toDoPanel;
    }

    /**
     * Set the message_board as current message_board for the project
     *
     * @param messageBoard a message_board object
     */
    @Override
    public void setMessageBoard(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    /**
     * Set the schedule as current schedule for the project
     *
     * @param schedule a schedule object
     */
    @Override
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * add new member into the project
     *
     * @param newMember the new member that join the project
     */
    @Override
    public void addNewMember(User newMember) {
        members.put(newMember.getID(), newMember);
    }
}