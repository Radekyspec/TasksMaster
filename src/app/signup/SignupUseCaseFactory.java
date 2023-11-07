package app.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import data_access.signup.SignupUserDataAccessInterface;
import view.signup.SignupView;

public class SignupUseCaseFactory {
    private SignupUseCaseFactory () {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel,
            SignupUserDataAccessInterface signupUserDataAccessObject) {
        SignupController signupController = createSignupController(viewManagerModel,
                loginViewModel, signupUserDataAccessObject);
        return new SignupView(signupViewModel, signupController);
    }

    private static SignupController createSignupController(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
            SignupUserDataAccessInterface signupUserDataAccessObject) {
        SignupOutputBoundary signupPresenter = new SignupPresenter(viewManagerModel, loginViewModel);
        SignupInputBoundary signupInteractor = new SignupInteractor(signupPresenter, signupUserDataAccessObject);
        return new SignupController(signupInteractor);
    }
}
