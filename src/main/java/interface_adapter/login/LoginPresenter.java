package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;
    private final ChooseProjectViewModel chooseProjectViewModel;
    private final AddProjectViewModel addProjectViewModel;
    private final MainProjectViewModel mainProjectViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
                          ChooseProjectViewModel chooseProjectViewModel, AddProjectViewModel addProjectViewModel, MainProjectViewModel mainProjectViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.chooseProjectViewModel = chooseProjectViewModel;
        this.addProjectViewModel = addProjectViewModel;
        this.mainProjectViewModel = mainProjectViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData loginOutputData) {
        chooseProjectViewModel.getState().setUser(loginOutputData.getUser());
        chooseProjectViewModel.firePropertyChanged(ChooseProjectViewModel.SET_USER);
        addProjectViewModel.getState().setUser(loginOutputData.getUser());
        addProjectViewModel.firePropertyChanged(AddProjectViewModel.SET_USER);
        mainProjectViewModel.getState().setUser(loginOutputData.getUser());
        mainProjectViewModel.firePropertyChanged(MainProjectViewModel.SET_USER);
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
