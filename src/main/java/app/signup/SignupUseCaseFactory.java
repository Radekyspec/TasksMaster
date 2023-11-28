package app.signup;

import data_access.signup.SignupUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.signup.SignupView;

public class SignupUseCaseFactory {
    private SignupUseCaseFactory() {
    }

    public static SignupView create(
            ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel,
            SignupUserDataAccessInterface signupUserDataAccessObject) {
        SignupController signupController = createSignupController(viewManagerModel,
                loginViewModel, signupViewModel, signupUserDataAccessObject);
        return new SignupView(viewManagerModel, signupViewModel, signupController, loginViewModel);
    }

    private static SignupController createSignupController(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel,
            SignupUserDataAccessInterface signupUserDataAccessObject) {
        SignupOutputBoundary signupPresenter = new SignupPresenter(viewManagerModel, loginViewModel, signupViewModel);
        SignupInputBoundary signupInteractor = new SignupInteractor(signupPresenter, signupUserDataAccessObject);
        return new SignupController(signupInteractor);
    }
}
