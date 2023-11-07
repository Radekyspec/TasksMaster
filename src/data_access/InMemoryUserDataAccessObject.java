package data_access;

import data_access.signup.SignupUserDataAccessInterface;

public class InMemoryUserDataAccessObject extends HttpDataAccessObject implements SignupUserDataAccessInterface {
    public InMemoryUserDataAccessObject(String apiKey) {
        super(apiKey);
    }

    @Override
    public boolean exists(String username) {
        return false;
    }
}
