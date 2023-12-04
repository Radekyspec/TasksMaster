package app.login;

import data_access.login.LoginUserDataAccessInterface;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoginUseCaseFactoryTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
        assertNotNull(LoginUseCaseFactory.create(
                new ViewManagerModel(),
                new SignupViewModel(),
                new LoginViewModel(),
                new ChooseProjectViewModel(),
                new AddProjectViewModel(),
                new MainProjectViewModel(),
                new LoginUserDataAccessInterface() {
                    @Override
                    public User login(String username, String password) {
                        return null;
                    }
                }
        ));
    }

    @Test
    void createLoginController() {
        assertNotNull(LoginUseCaseFactory.createLoginController(
                new ViewManagerModel(),
                new LoginViewModel(),
                new ChooseProjectViewModel(),
                new AddProjectViewModel(),
                new MainProjectViewModel(),
                new LoginUserDataAccessInterface() {
                    @Override
                    public User login(String username, String password) {
                        return null;
                    }
                }
        ));
    }
}