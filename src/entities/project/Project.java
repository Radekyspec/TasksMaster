package entities.project;

import entities.message_board.MessageBoard;
import entities.schedule.Schedule;
import entities.todo_panel.ToDoPanel;
import entities.user.User;

import java.util.Map;

public interface Project {
    int getID();

    String getName();

    User getLeader();

    Map<Integer, User> getMembers();

    ToDoPanel getToDoPanel();

    MessageBoard getMessageBoard();

    Schedule getSchedule();

    void setToDoPanel(ToDoPanel toDoPanel);

    void setMessageBoard(MessageBoard messageBoard);

    void setSchedule(Schedule schedule);
}
