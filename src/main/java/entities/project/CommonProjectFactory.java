package entities.project;

import entities.user.User;

public class CommonProjectFactory {
    /**
     * Create a CommonProject object.
     *
     * @param ID     the ID of the project
     * @param name   the name of the project
     * @param leader the leader of the project
     */
    public static CommonProject create(int ID, String name, User leader) {
        return new CommonProject(ID, name, leader);
    }
}
