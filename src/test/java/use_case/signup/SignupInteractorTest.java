package use_case.signup;

import data_access.signup.SignupUserDataAccessInterface;
import entities.user.User;
import interface_adapter.signup.SignupPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupInteractorTest {
    private SignupUserDataAccessInterface userDAO;
    private SignupOutputBoundary presenter;
    private SignupInputBoundary interactor;

    @BeforeEach
    void setUp() {
        userDAO = new SignupUserDataAccessInterface() {
            @Override
            public boolean exists(String username) {
                return username == null;
            }

            @Override
            public void save(User user) {

            }
        };
        presenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData signupOutputData) {
                assertFalse(signupOutputData.isUseCaseFailed());
                assertEquals("", signupOutputData.getError());
            }

            @Override
            public void prepareFailView(SignupOutputData signupOutputData) {
                assertTrue(signupOutputData.isUseCaseFailed());
            }
        };
        interactor = new SignupInteractor(presenter, userDAO);
    }

    @Test
    void execute() {
        interactor.execute(new SignupInputData(null, "", "",""));
        interactor.execute(new SignupInputData("", ",", "1", "2"));
        interactor.execute(new SignupInputData("", "", "", ""));
    }
}