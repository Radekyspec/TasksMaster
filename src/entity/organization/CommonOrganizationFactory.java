package entity.organization;

import entity.user.User;

public class CommonOrganizationFactory {
    public static CommonOrganization create(int ID, String name, User owner){
        return new CommonOrganization(ID, name, owner);
    }
}
