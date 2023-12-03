package entities.user;

import entities.organization.Organization;

import java.time.LocalDateTime;

public interface User {
    /**
     * Return the ID of the User
     *
     * @return its ID
     */
    long getID();

    /**
     * Return the organization that User is in
     *
     * @return its organization
     */
    Organization getOrganization();

    /**
     * Return the name of the User
     *
     * @return its name
     */
    String getName();

    /**
     * Return the password of the User
     *
     * @return its password
     */
    String getPassword();

    /**
     * Return the created time of the User
     *
     * @return its creation_time
     */
    LocalDateTime getCreationTime();

    /**
     * Return the email of the User
     *
     * @return its email
     */
    String getEmail();

    /**
     * set the rule of the User, including Boss, Leader and Member
     */

    void setRule(Rule rule);

    /**
     * let user join a organization
     *
     * @param organization an organization that user want to join
     */
    void joinOrganization(Organization organization);

}