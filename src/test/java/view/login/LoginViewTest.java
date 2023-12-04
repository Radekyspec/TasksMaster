package view.login;

import app.login.LoginUseCaseFactory;
import data_access.login.LoginUserDataAccessInterface;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginViewTest {
    private LoginView loginView;
    private LoginView loginView1;
    private LoginViewModel loginViewModel = new LoginViewModel();

    @BeforeEach
    void setUp() {
        loginView1 = LoginUseCaseFactory.create(
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
        );
        LoginController controller = new LoginController(loginInputData -> {

        });
        loginView = new LoginView(new ViewManagerModel(), new SignupViewModel(), loginViewModel, controller);
    }

    @Test
    void actionPerformed() {
        loginView.actionPerformed(new ActionEvent(new Object(), 1, ""));
    }

    @Test
    void propertyChange() {
        loginViewModel.getLoginState().setLoginError("error message test");

        Timer t = new Timer(1000, e -> {
            for (Window window : Window.getWindows()) {
                if (window instanceof JDialog) {
                    window.dispose();
                }
            }
        });
        t.setRepeats(false);
        t.start();
        loginViewModel.firePropertyChanged();
    }

    @Test
    void getViewName() {
        assertEquals(loginView.getViewName(), "log in");
        assertEquals(loginView1.getViewName(), "log in");
    }
}