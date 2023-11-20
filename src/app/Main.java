package app;

import app.login.LoginUseCaseFactory;
import app.signup.SignupUseCaseFactory;
import data_access.InMemoryUserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import view.ViewManager;
import view.login.LoginView;
import view.signup.SignupView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("TasksMaster");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(cardLayout, views, viewManagerModel);

        String API_KEY = System.getenv("API_KEY");

        InMemoryUserDataAccessObject userDAO;
        userDAO = new InMemoryUserDataAccessObject(API_KEY);

        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupView signupView = SignupUseCaseFactory.create(
                viewManagerModel, signupViewModel, loginViewModel, userDAO);
        LoginView loginView = LoginUseCaseFactory.create(
                viewManagerModel, signupViewModel, loginViewModel, userDAO);
        views.add(signupView, signupView.getViewName());
        views.add(loginView, loginView.getViewName());

        viewManagerModel.setActiveView(loginView.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
