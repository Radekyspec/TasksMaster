package use_case.login;

import data_access.login.LoginUserDataAccessInterface;
import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {
    private User user;
    private LoginInputBoundary interactor;

    @BeforeEach
    void setUp() {
        LoginUserDataAccessInterface userDAO = new LoginUserDataAccessInterface() {
            private final Map<String, User> accounts = new HashMap<>();

            @Override
            public User login(String username, String password) {
                accounts.put(user.getName(), user);
                if (username.isEmpty() || password.isEmpty() || !accounts.containsKey(username)) {
                    return null;
                }
                if (accounts.get(username).getPassword().equals(password)) {
                    return accounts.get(username);
                }
                return null;
            }
        };
        user = CommonUserFactory.create(
                440782,
                "A",
                "Aa1",
                LocalDateTime.parse("2023-11-29T03:50:31.757210800"),
                "1@a.a"
        );
        LoginOutputBoundary loginPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData loginOutputData) {
                assertEquals(user.getName(), loginOutputData.getUser().getName());
                assertEquals(user.getPassword(), loginOutputData.getUser().getPassword());
                assertEquals(user.getEmail(), loginOutputData.getUser().getEmail());
                assertEquals(user.getID(), loginOutputData.getUser().getID());
                assertEquals(0, user.getCreationTime().compareTo(loginOutputData.getUser().getCreationTime()));
                assertNull(loginOutputData.getError());
                assertFalse(loginOutputData.isUseCaseFailed());
            }

            @Override
            public void prepareFailView(LoginOutputData loginOutputData) {
                assertNull(loginOutputData.getUser());
                assertEquals("Incorrect username or password", loginOutputData.getError());
                assertTrue(loginOutputData.isUseCaseFailed());
            }
        };
        interactor = new LoginInteractor(loginPresenter, userDAO);
    }

    @Test
    void execute() {
        LoginInputData inputData = new LoginInputData(user.getName(), user.getPassword());
        interactor.execute(inputData);
        interactor.execute(new LoginInputData("", ""));
    }
}