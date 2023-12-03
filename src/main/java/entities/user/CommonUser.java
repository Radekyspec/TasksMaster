package entities.user;

import entities.organization.Organization;

import java.time.LocalDateTime;

public class CommonUser implements User {
    private final long ID;
    private Organization organization;
    private final String name;
    private final String password;
    private final String email;
    private final LocalDateTime createDateTime;
    private Rule rule;

    /**
     * build up a new user
     *
     * @param ID             the unique ID of user
     * @param name           the name of user
     * @param password       the password of user
     * @param createDateTime the time when user account created
     * @param email          the email user used to sign up account
     */
    public CommonUser(long ID, String name, String password, LocalDateTime createDateTime, String email) {
        this.ID = ID;
        organization = null;
        this.name = name;
        this.password = password;
        this.createDateTime = createDateTime;
        this.email = email;
    }

    /**
     * Return the ID of the User
     *
     * @return its ID
     */
    @Override
    public long getID() {
        return ID;
    }

    /**
     * Return the organization that User is in
     *
     * @return its organization
     */
    @Override
    public Organization getOrganization() {
        return organization;
    }

    /**
     * Return the name of the User
     *
     * @return its name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Return the password of the User
     *
     * @return its password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Return the created time of the User
     *
     * @return its creation_time
     */
    @Override
    public LocalDateTime getCreationTime() {
        return createDateTime;
    }

    /**
     * Return the email of the User
     *
     * @return its email
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * set the rule of the User, including Boss, Leader and Member
     */
    @Override
    public void setRule(Rule rule) {
        this.rule = rule;
    }

    /**
     * let user join a organization
     *
     * @param organization an organization that user want to join
     */
    @Override
    public void joinOrganization(Organization organization) {
        this.organization = organization;
    }


}
