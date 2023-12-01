package entities.project;

import entities.message_board.MessageBoard;
import entities.schedule.Schedule;
import entities.todo_panel.ToDoPanel;

import java.util.List;

public interface Project {
    /**
     * Return the ID of the Project
     *
     * @return its ID
     */
    int getID();

    String getLeader();

    void setLeader(String leader);

    /**
     * Return the name of the Project
     *
     * @return its name
     */
    String getName();

    String getDescription();

    /**
     * Return all members of the Project
     *
     * @return its members
     */
    List<String> getMembers();

    /**
     * Return the to_do panel of the Project
     *
     * @return a to_do panel of the current project
     */
    ToDoPanel getToDoPanel();

    /**
     * Return the MessageBoard of the Project
     *
     * @return a message_board of the current project
     */
    MessageBoard getMessageBoard();

    /**
     * Return the schedule of the Project
     *
     * @return a schedule of the current project
     */
    Schedule getSchedule();

    /**
     * Set the to_do panel as current to_do panel for the project
     *
     * @param toDoPanel a to_do panel object
     */
    void setToDoPanel(ToDoPanel toDoPanel);

    /**
     * Set the message_board as current message_board for the project
     *
     * @param messageBoard a message_board object
     */
    void setMessageBoard(MessageBoard messageBoard);

    /**
     * Set the schedule as current schedule for the project
     *
     * @param schedule a schedule object
     */
    void setSchedule(Schedule schedule);

    /**
     * add new member into the project
     *
     * @param newMember the new member that join the project
     */
    void addNewMember(String newMember);
}
