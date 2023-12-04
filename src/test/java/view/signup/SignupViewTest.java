package view.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class SignupViewTest {
    private SignupView signupView;
    private SignupViewModel signupViewModel = new SignupViewModel();
    @BeforeEach
    void setUp() {
        SignupController controller = new SignupController(signupInputData -> {

        });
        signupView = new SignupView(new ViewManagerModel(), new SignupViewModel(), controller, new LoginViewModel());
    }

    @Test
    void getViewName() {
        assertEquals("sign up", signupView.getViewName());
    }

    @Test
    void actionPerformed() {
        signupView.actionPerformed(new ActionEvent(new Object(), 1, ""));
    }

    @Test
    void propertyChange() {
        signupViewModel.getSignupState().setSignupError("error message test");
        signupViewModel.firePropertyChanged();

    }
}