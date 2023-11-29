package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;
    private final ChooseProjectViewModel chooseProjectViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
                          ChooseProjectViewModel chooseProjectViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.chooseProjectViewModel = chooseProjectViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData loginOutputData) {
        chooseProjectViewModel.getState().setUser(loginOutputData.getUser());
        chooseProjectViewModel.firePropertyChanged(ChooseProjectViewModel.SET_USER);
        // TODO: set user to all views
        viewManagerModel.setActiveView(chooseProjectViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
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
