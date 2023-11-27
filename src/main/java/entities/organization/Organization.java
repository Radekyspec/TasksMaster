package entities.organization;

import entities.project.Project;
import entities.user.User;

import java.util.Map;

public interface Organization {
    /**
     * Return the ID of the Organization
     * @return its ID
     */
    int getID();

    /**
     * Return the name of the Organization
     * @return its name
     */
    String getName();

    /**
     * Return the owner of the Organization
     * @return its owner
     */
    User getOwner();

    /**
     * Return the set of all project of the Organization
     * @return its project_set
     */
    Map<Integer, Project> getProject_set();

    /**
     * Return all members of the Organization
     * @return its members in the Organization
     */
    Map<Integer, User> getMembers();
}
