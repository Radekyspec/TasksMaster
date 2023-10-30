package entity.project;

import entity.user.User;

import java.util.Map;

public class CommonProject {
    private final int ID;
    private final String name;
    private final User leader;
    private final Map<Integer, User> members;
    private final ToDoPanel toDoPanel;
    private final MessageBoard messageBoard;
    private final Schedule schedule;
}
