package app.login;

import data_access.login.LoginUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import view.login.LoginView;

public class LoginUseCaseFactory {
    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {
        LoginController loginController = LoginUseCaseFactory.createLoginController(
                viewManagerModel, loginViewModel, userDataAccessObject);
        return new LoginView(viewManagerModel, signupViewModel, loginViewModel, loginController);

    }

    private static LoginController createLoginController(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {
        LoginOutputBoundary loginPresenter = new LoginPresenter(viewManagerModel, loginViewModel);
        LoginInputBoundary loginInteractor = new LoginInteractor(loginPresenter, userDataAccessObject);
        return new LoginController(loginInteractor);
    }
}
