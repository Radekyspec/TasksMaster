package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

public class SignupPresenter implements SignupOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;
    private final SignupViewModel signupViewModel;

    public SignupPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
                           SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData signupOutputData) {
        if (signupOutputData.isUseCaseFailed()) {
            return;
        }
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(SignupOutputData signupOutputData) {
        if (!signupOutputData.isUseCaseFailed()) {
            return;
        }
        signupViewModel.getSignupState().setSignupError(signupOutputData.getError());
        signupViewModel.firePropertyChanged();
    }
}
