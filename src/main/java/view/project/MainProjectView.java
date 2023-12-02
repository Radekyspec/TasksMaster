package view.project;

import entities.project.Project;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardState;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.project.MainProjectController;
import interface_adapter.project.MainProjectState;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add_people.AddPeopleViewModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainProjectView extends JPanel implements ActionListener, PropertyChangeListener {
    private User user;
    private Project project;
    private final ViewManagerModel viewManagerModel;
    private final MainProjectViewModel mainProjectViewModel;
    private final MessageBoardViewModel messageBoardViewModel;
    private final ToDoPanelViewModel toDoPanelViewModel;
    private final AddPeopleViewModel addPeopleViewModel;
    private final ScheduleViewModel scheduleViewModel;
    private final JLabel projectName = new JLabel();
    private final JLabel description = new JLabel();
    private final JButton addSomePeople = new JButton(MainProjectViewModel.ADD_NEW_PEOPLE);
    private final JButton messageBoard = new JButton(MainProjectViewModel.MESSAGE_BOARD);
    private final JButton toDoPanel = new JButton(MainProjectViewModel.TO_DO_PANEL);
    private final JButton schedule = new JButton(MainProjectViewModel.SCHEDULE);
    private final JPanel buttonField = new JPanel();

    public MainProjectView(ViewManagerModel viewManagerModel, MainProjectViewModel mainProjectViewModel,
                           MessageBoardViewModel messageBoardViewModel, ToDoPanelViewModel toDoPanelViewModel,
                           AddPeopleViewModel addPeopleViewModel, ScheduleViewModel scheduleViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainProjectViewModel = mainProjectViewModel;
        this.messageBoardViewModel = messageBoardViewModel;
        this.toDoPanelViewModel = toDoPanelViewModel;
        this.addPeopleViewModel = addPeopleViewModel;
        this.scheduleViewModel = scheduleViewModel;

        addSomePeople.addActionListener(
                e -> {
                    addPeopleViewModel.getState().setProject(project);
                    viewManagerModel.setActiveView(addPeopleViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        JPanel title = new JPanel();
        title.add(projectName);
        title.add(description);
        this.add(title);
        this.add(addSomePeople);
        buttonField.add(messageBoard);
        buttonField.add(toDoPanel);
        buttonField.add(schedule);
        this.add(buttonField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(messageBoard)){
            MessageBoardState messageBoardState = messageBoardViewModel.getMessageBoardState();
            messageBoardState.setUser(user);
            messageBoardState.setProjectID(project.getID());
            messageBoardState.setMessageBoard(project.getMessageBoard());
            messageBoardState.setMessageBoardID(project.getMessageBoard().getID());
            messageBoardViewModel.firePropertyChanged(MessageBoardViewModel.SET_USER_PROJECT);
            viewManagerModel.setActiveView(messageBoardViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        } else if (e.getSource().equals(toDoPanel)) {

        } else if (e.getSource().equals(schedule)) {

        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MainProjectState state = (MainProjectState) evt.getNewValue();
        switch (evt.getPropertyName()){
            case MainProjectViewModel.SET_USER -> user = state.getUser();
            case MainProjectViewModel.SET_PROJECT -> {
                project = state.getProject();
                projectName.setText(project.getName());
                description.setText(project.getDescription());
                messageBoard.addActionListener(this);
                toDoPanel.addActionListener(this);
                schedule.addActionListener(this);
            }
        }
    }
    public String getViewName(){
        return mainProjectViewModel.getViewName();
    }
}
