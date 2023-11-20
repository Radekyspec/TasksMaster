package entities.user;

import java.time.LocalDateTime;

public class CommonUserFactory {
    /**
     * Create a new user
     * @param ID the unique ID of user
     * @param name the name of user
     * @param password the password of user
     * @param createDateTime the time when user account created
     * @param email the email user used to sign up account
     * @return a new user object
     */
    public static User create(int ID, String name, String password, LocalDateTime createDateTime, String email) {
        return new CommonUser(ID, name, password, createDateTime, email);
    }
}
