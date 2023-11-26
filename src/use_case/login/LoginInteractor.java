package use_case.login;

import data_access.login.LoginUserDataAccessInterface;
import entities.user.User;

public class LoginInteractor implements LoginInputBoundary {
    private final LoginOutputBoundary loginPresenter;
    private final LoginUserDataAccessInterface userDataAccessObject;

    public LoginInteractor(LoginOutputBoundary loginPresenter, LoginUserDataAccessInterface userDataAccessObject) {
        this.loginPresenter = loginPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        User user = userDataAccessObject.login(
                loginInputData.getUsername(),
                loginInputData.getPassword()
        );
        if (user == null) {
            LoginOutputData outputData = new LoginOutputData(
                    null,
                    "Incorrect username or password",
                    true
            );
            loginPresenter.prepareFailView(outputData);
            return;
        }
        LoginOutputData outputData = new LoginOutputData(
                user,
                null,
                false
        );
        loginPresenter.prepareSuccessView(outputData);
    }
}
