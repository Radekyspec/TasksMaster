package data_access;

import data_access.login.LoginUserDataAccessInterface;
import data_access.signup.SignupUserDataAccessInterface;

public class InMemoryUserDataAccessObject extends HttpDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface {
    public InMemoryUserDataAccessObject(String apiKey) {
        super(apiKey);
    }

    @Override
    public boolean exists(String username) {
        return false;
    }
}
