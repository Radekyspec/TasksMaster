package entity.project;

import entity.user.User;

import java.util.Map;

public interface Project {
    int getID();
    String getName();
    User getLeader();
    Map<Integer, User> getMembers();

}
