package data_access.login;

import entities.user.User;

public interface LoginUserDataAccessInterface {
    User login(String username, String password);
}
