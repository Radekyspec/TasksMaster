package entities.user;

import entities.organization.Organization;

import java.time.LocalDateTime;

public class CommonUser implements User {
    private final int ID;
    private final Organization organization;
    private final String name;
    private final String password;
    private final String email;
    private final LocalDateTime creatDateTime;
    private final Rule rule;

    public CommonUser(int ID, String name, String password, LocalDateTime creatDateTime, String email) {
        this.ID = ID;
        organization = null;
        this.name = name;
        this.password = password;
        this.creatDateTime = creatDateTime;
        this.email = email;
        rule = null;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creatDateTime;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setRule() {

    }


}
