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
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {
    private LoginView loginView;
    private LoginViewModel loginViewModel = new LoginViewModel();

    @BeforeEach
    void setUp() {
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
        loginViewModel.getLoginState().setLoginError("123");
        loginViewModel.firePropertyChanged();
    }

    @Test
    void getViewName() {
        assertEquals(loginView.getViewName(), "log in");
    }
}