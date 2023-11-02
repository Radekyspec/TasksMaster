package entities.project;

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
    void setToPanel();
    void setMessageBoard();
    void setSchedule();
}
