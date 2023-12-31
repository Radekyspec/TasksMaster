package app;

import app.login.LoginUseCaseFactory;
import app.message_board.MessageBoardUseCaseFactory;
import app.message_board.add_new_message.AddNewMessageUseCaseFactory;
import app.message_board.message.MessageUseCaseFactory;
import app.project.ProjectUseCaseFactory;
import app.project.add.AddProjectUseCaseFactory;
import app.project.add_people.AddPeopleUseCaseFactory;
import app.project.choose.ChooseProjectUseCaseFactory;
import app.schedule.ScheduleUseCaseFactory;
import app.schedule.add_new_event.AddNewEventUseCaseFactory;
import app.signup.SignupUseCaseFactory;
import app.todo.AddToDoUseCaseFactory;
import app.todo_list.AddToDoListUseCaseFactory;
import app.todo_list.ToDoListUseCaseFactory;
import app.todo_panel.ToDoPanelUseCaseFactory;
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
import interface_adapter.schedule.event.AddEventViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_list.add.AddToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import view.ViewManager;
import view.login.LoginView;
import view.message_board.AddNewMessageView;
import view.message_board.MessageBoardView;
import view.message_board.MessageView;
import view.project.MainProjectView;
import view.project.add.AddProjectView;
import view.project.add_people.AddPeopleView;
import view.project.choose.ChooseProjectView;
import view.schedule.AddNewEventView;
import view.schedule.ScheduleView;
import view.signup.SignupView;
import view.todo.AddToDoView;
import view.todo_list.AddToDoListView;
import view.todo_list.ToDoListView;
import view.todo_panel.ToDoPanelView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("TasksMaster");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setSize(1280, 720);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(cardLayout, views, viewManagerModel);

//        String API_KEY = System.getenv("API_KEY");
        String API_KEY = "BAhbB0kiAbB7ImNsaWVudF9pZCI6ImU1Mzc4MTlhMDA3YzQ4ODU4MWM3ZjI2OGIyYTc0ZmEzNDU5NzU4M2QiLCJleHBpcmVzX2F0IjoiMjAyMy0xMi0xMVQwMzo1OTowNVoiLCJ1c2VyX2lkcyI6WzQ4NjQyMDUxXSwidmVyc2lvbiI6MSwiYXBpX2RlYWRib2x0IjoiZTVkNTFmNjM0Y2ZmYjA0ZmE1M2FmOWEzYjg0Mjg0NjkifQY6BkVUSXU6CVRpbWUNY+0ewLmxVewJOg1uYW5vX251bWkCjQM6DW5hbm9fZGVuaQY6DXN1Ym1pY3JvIgeQkDoJem9uZUkiCFVUQwY7AEY=--fcf956b3050afbd54e783afe6f8df60a3f12127b";
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
        ToDoListViewModel toDoListViewModel = new ToDoListViewModel();
        AddToDoListViewModel addToDoListViewModel = new AddToDoListViewModel();
        AddToDoViewModel addToDoViewModel = new AddToDoViewModel();

        ScheduleViewModel scheduleViewModel = new ScheduleViewModel();
        AddEventViewModel addEventViewModel = new AddEventViewModel();

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


        MessageBoardView messageBoardView = MessageBoardUseCaseFactory.create(viewManagerModel, mainProjectViewModel, messageBoardViewModel,
                addNewMessageViewModel, messageViewModel, userDAO);
        ToDoPanelView toDoPanelView = ToDoPanelUseCaseFactory.create(
                viewManagerModel, addToDoListViewModel, mainProjectViewModel, toDoPanelViewModel, toDoListViewModel, userDAO
        );
        ToDoListView toDoListView = ToDoListUseCaseFactory.create(
                viewManagerModel, toDoListViewModel, mainProjectViewModel, toDoPanelViewModel, addToDoViewModel, userDAO
        );
        AddToDoListView addToDoListView = AddToDoListUseCaseFactory.create(
                viewManagerModel, addToDoListViewModel, toDoPanelViewModel, userDAO
        );
        AddToDoView addToDoView = AddToDoUseCaseFactory.create(
                viewManagerModel, addToDoViewModel, toDoListViewModel, userDAO
        );
        AddNewMessageView addNewMessageView = AddNewMessageUseCaseFactory.create(viewManagerModel, addNewMessageViewModel, messageBoardViewModel, userDAO);
        MessageView messageView = MessageUseCaseFactory.create(viewManagerModel, messageViewModel, messageBoardViewModel, userDAO);
        ScheduleView scheduleView = ScheduleUseCaseFactory.create(viewManagerModel, mainProjectViewModel, scheduleViewModel, addEventViewModel, userDAO);
        AddNewEventView addNewEventView = AddNewEventUseCaseFactory.create(viewManagerModel, addEventViewModel, scheduleViewModel, userDAO);

        views.add(signupView, signupView.getViewName());
        views.add(loginView, loginView.getViewName());
        views.add(chooseProjectView, chooseProjectView.getViewName());
        views.add(addProjectView, addProjectView.getViewName());
        views.add(mainProjectView, mainProjectView.getViewName());
        views.add(addPeopleView, addPeopleView.getViewName());
        views.add(messageBoardView, messageBoardView.getViewName());
        views.add(addNewMessageView, addNewMessageView.getViewName());
        views.add(messageView, messageView.getViewName());
        views.add(toDoPanelView, toDoPanelView.getViewName());
        views.add(toDoListView, toDoListView.getViewName());
        views.add(addToDoListView, addToDoListView.getViewName());
        views.add(addToDoView, addToDoView.getViewName());
        views.add(scheduleView, scheduleView.getViewName());
        views.add(addNewEventView, addNewEventView.getViewName());

        viewManagerModel.setActiveView(loginView.getViewName());
        viewManagerModel.firePropertyChanged();

//        application.pack();
        application.validate();
        application.setVisible(true);
    }
}
