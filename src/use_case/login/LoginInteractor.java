package use_case.login;

import data_access.login.LoginUserDataAccessInterface;

public class LoginInteractor implements LoginInputBoundary {
    private final LoginOutputBoundary loginPresenter;
    private final LoginUserDataAccessInterface userDataAccessObject;

    public LoginInteractor(LoginOutputBoundary loginPresenter, LoginUserDataAccessInterface userDataAccessObject) {
        this.loginPresenter = loginPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        // main login logic here
    }
}
