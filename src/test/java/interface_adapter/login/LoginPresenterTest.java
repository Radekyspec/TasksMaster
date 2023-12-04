package interface_adapter.login;

import entities.user.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LoginPresenterTest {
    private LoginOutputBoundary presenter;

    @BeforeEach
    void setUp() {
        presenter = new LoginPresenter(
                new ViewManagerModel(),
                new LoginViewModel(),
                new ChooseProjectViewModel(),
                new AddProjectViewModel(),
                new MainProjectViewModel()
        );
    }

    @Test
    void prepareSuccessView() {
        presenter.prepareSuccessView(new LoginOutputData(null, null, false));
    }

    @Test
    void prepareFailView() {
        presenter.prepareFailView(new LoginOutputData(null, null, false));
        presenter.prepareFailView(new LoginOutputData(null, null, true));
    }
}