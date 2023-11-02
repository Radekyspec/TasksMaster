package entities.organization;

import entities.project.Project;
import entities.user.User;

import java.util.Map;

public interface Organization {
    int getID();
    String getName();
    User getOwner();
    Map<Integer, Project> getProject_set();
    Map<Integer, User> getMembers();
}
