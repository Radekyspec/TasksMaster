package entities.organization;

import entities.project.Project;
import entities.user.User;

import java.util.HashMap;
import java.util.Map;

public class CommonOrganization implements Organization {
    private final int ID;
    private final String name;
    private final User owner;
    private final Map<Integer, Project> project_set;
    private final Map<Integer, User> members;

    public CommonOrganization(int ID, String name, User owner) {
        this.ID = ID;
        this.name = name;
        this.owner = owner;
        project_set = new HashMap<>();
        members = new HashMap<>();
    }

    /**
     * Return the ID of the Organization
     * @return its ID
     */
    @Override
    public int getID() {
        return ID;
    }

    /**
     * Return the name of the Organization
     * @return its name
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    @Override
    public Map<Integer, Project> getProject_set() {
        return project_set;
    }

    @Override
    public Map<Integer, User> getMembers() {
        return members;
    }
}
