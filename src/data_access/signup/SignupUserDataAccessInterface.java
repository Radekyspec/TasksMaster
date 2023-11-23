package data_access.signup;

import entities.user.User;

public interface SignupUserDataAccessInterface {
    boolean exists(String username);
    void save(User user);
}
