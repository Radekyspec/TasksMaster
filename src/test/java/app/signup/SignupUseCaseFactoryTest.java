package app.signup;

import data_access.signup.SignupUserDataAccessInterface;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupUseCaseFactoryTest {

    @Test
    void create() {
        assertNotNull(SignupUseCaseFactory.create(
                new ViewManagerModel(),
                new SignupViewModel(),
                new LoginViewModel(),
                new SignupUserDataAccessInterface() {
                    @Override
                    public boolean exists(String username) {
                        return false;
                    }

                    @Override
                    public void save(User user) {

                    }
                }
        ));
    }

    @Test
    void createSignupController() {
        assertInstanceOf(SignupController.class, SignupUseCaseFactory.createSignupController(
                new ViewManagerModel(),
                new LoginViewModel(),
                new SignupViewModel(),
                new SignupUserDataAccessInterface() {
                    @Override
                    public boolean exists(String username) {
                        return false;
                    }

                    @Override
                    public void save(User user) {

                    }
                }
        ));
    }
}