package app;

import app.message_board.MessageBoardUseCaseFactory;
import app.login.LoginUseCaseFactory;
import app.project.ProjectUseCaseFactory;
import app.project.add.AddProjectUseCaseFactory;
import app.project.add_people.AddPeopleUseCaseFactory;
import app.project.choose.ChooseProjectUseCaseFactory;
import app.signup.SignupUseCaseFactory;
import data_access.InMemoryUserDataAccessObject;
import exceptions.InvalidApiKeyException;
import exceptions.InvalidUserConfigException;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.add_new_message.AddNewMessageViewModel;
import interface_adapter.message_board.message.MessageViewModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.add_people.AddPeopleViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import view.ViewManager;
import view.login.LoginView;
import view.message_board.MessageBoardView;
import view.project.MainProjectView;
import view.project.add.AddProjectView;
import view.project.add_people.AddPeopleView;
import view.project.choose.ChooseProjectView;
import view.signup.SignupView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("TasksMaster");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setSize(600, 450);



        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(cardLayout, views, viewManagerModel);

        String API_KEY = System.getenv("API_KEY");

        InMemoryUserDataAccessObject userDAO;
        try {
            userDAO = new InMemoryUserDataAccessObject(API_KEY, "./users.csv");
        } catch (InvalidUserConfigException | IOException | InvalidApiKeyException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }


        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        ChooseProjectViewModel chooseProjectViewModel = new ChooseProjectViewModel();
        AddProjectViewModel addProjectViewModel = new AddProjectViewModel();
        MainProjectViewModel mainProjectViewModel = new MainProjectViewModel();
        AddPeopleViewModel addPeopleViewModel = new AddPeopleViewModel();

        MessageBoardViewModel messageBoardViewModel = new MessageBoardViewModel();
        MessageViewModel messageViewModel = new MessageViewModel();
        AddNewMessageViewModel addNewMessageViewModel = new AddNewMessageViewModel();

        ToDoPanelViewModel toDoPanelViewModel = new ToDoPanelViewModel();

        ScheduleViewModel scheduleViewModel = new ScheduleViewModel(1,2);

        SignupView signupView = SignupUseCaseFactory.create(
                viewManagerModel, signupViewModel, loginViewModel, userDAO);
        LoginView loginView = LoginUseCaseFactory.create(
                viewManagerModel, signupViewModel, loginViewModel, chooseProjectViewModel, addProjectViewModel,
                mainProjectViewModel, userDAO);
        ChooseProjectView chooseProjectView = ChooseProjectUseCaseFactory.create(
                viewManagerModel, addProjectViewModel, chooseProjectViewModel, mainProjectViewModel, userDAO
        );
        AddProjectView addProjectView = AddProjectUseCaseFactory.create(
                viewManagerModel, addProjectViewModel, chooseProjectViewModel, userDAO
        );

        MainProjectView mainProjectView = ProjectUseCaseFactory.create(viewManagerModel, chooseProjectViewModel, mainProjectViewModel,
                messageBoardViewModel, toDoPanelViewModel, addPeopleViewModel, scheduleViewModel);
        AddPeopleView addPeopleView = AddPeopleUseCaseFactory.create(viewManagerModel, addPeopleViewModel,
                mainProjectViewModel, userDAO);

//        MessageBoardView messageBoardView = MessageBoardUseCaseFactory.create(viewManagerModel, messageBoardViewModel,
//                addNewMessageViewModel, messageViewModel, userDAO);

        views.add(signupView, signupView.getViewName());
        views.add(loginView, loginView.getViewName());
        views.add(chooseProjectView, chooseProjectView.getViewName());
        views.add(addProjectView, addProjectView.getViewName());
        views.add(mainProjectView, mainProjectView.getViewName());
        views.add(addPeopleView, addPeopleView.getViewName());

        viewManagerModel.setActiveView(loginView.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        //application.validate();
        application.setVisible(true);
    }
}
