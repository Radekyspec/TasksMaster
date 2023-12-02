package entities.project;

import entities.message_board.MessageBoard;
import entities.schedule.Schedule;
import entities.todo_panel.ToDoPanel;

import java.util.ArrayList;
import java.util.List;

public class CommonProject implements Project {
    private final int ID;
    private final String name;
    private final String description;
    private final List<String> members;
    private String leader;
    private ToDoPanel toDoPanel;
    private MessageBoard messageBoard;
    private Schedule schedule;

    /**
     * build a CommonProject object.
     *
     * @param ID          the ID of the project
     * @param name        the name of the project
     * @param description
     */
    public CommonProject(int ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.members = new ArrayList<>();
    }

    @Override
    public String getLeader() {
        return leader;
    }

    @Override
    public void setLeader(String leader) {
        this.leader = leader;
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

    @Override
    public String getDescription() {
        return description;
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
     * Return all members of the Project
     *
     * @return its members
     */
    @Override
    public List<String> getMembers() {
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
    public void addNewMember(String newMember) {
        members.add(newMember);
    }
}