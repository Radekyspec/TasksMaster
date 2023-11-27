package entities.organization;

import entities.user.User;

public class CommonOrganizationFactory {
    /**
     * Create a new organization with ID, organization name, and owner.
     *
     * @param ID    the ID of organization
     * @param name  the name of organization
     * @param owner the owner of organization
     * @return a new CommonOrganization object
     */
    public static CommonOrganization create(int ID, String name, User owner) {
        return new CommonOrganization(ID, name, owner);
    }
}
