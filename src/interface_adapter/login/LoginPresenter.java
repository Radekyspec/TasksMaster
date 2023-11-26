package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData loginOutputData) {
        // switch to main project view
    }

    @Override
    public void prepareFailView(LoginOutputData loginOutputData) {
        if (!loginOutputData.isUseCaseFailed()) {
            return;
        }
        loginViewModel.getLoginState().setLoginError(loginOutputData.getError());
        loginViewModel.firePropertyChanged();
    }
}
