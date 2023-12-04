package view.project;

import entities.project.Project;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardState;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.project.MainProjectState;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add_people.AddPeopleViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import interface_adapter.schedule.ScheduleState;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.todo_panel.ToDoPanelState;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainProjectView extends JPanel implements ActionListener, PropertyChangeListener {
    private User user;
    private Project project;
    private final ViewManagerModel viewManagerModel;
    private final ChooseProjectViewModel chooseProjectViewModel;
    private final MainProjectViewModel mainProjectViewModel;
    private final MessageBoardViewModel messageBoardViewModel;
    private final ToDoPanelViewModel toDoPanelViewModel;
    private final AddPeopleViewModel addPeopleViewModel;
    private final ScheduleViewModel scheduleViewModel;
    private final JLabel projectName = new JLabelWithFont();
    private final JLabel description = new JLabelWithFont();
    private final JLabel author = new JLabelWithFont();
    private final JButton addSomePeople = new JButtonWithFont(MainProjectViewModel.ADD_NEW_PEOPLE);
    private final JButton messageBoard = new JButtonWithFont(MainProjectViewModel.MESSAGE_BOARD);
    private final JButton toDoPanel = new JButtonWithFont(MainProjectViewModel.TO_DO_PANEL);
    private final JButton schedule = new JButtonWithFont(MainProjectViewModel.SCHEDULE);
    private final JPanel buttonField = new JPanel();

    public MainProjectView(ViewManagerModel viewManagerModel, ChooseProjectViewModel chooseProjectViewModel, MainProjectViewModel mainProjectViewModel,
                           MessageBoardViewModel messageBoardViewModel, ToDoPanelViewModel toDoPanelViewModel,
                           AddPeopleViewModel addPeopleViewModel, ScheduleViewModel scheduleViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.chooseProjectViewModel = chooseProjectViewModel;
        this.mainProjectViewModel = mainProjectViewModel;
        this.messageBoardViewModel = messageBoardViewModel;
        this.toDoPanelViewModel = toDoPanelViewModel;
        this.addPeopleViewModel = addPeopleViewModel;
        this.scheduleViewModel = scheduleViewModel;
        mainProjectViewModel.addPropertyChangeListener(this);

        addSomePeople.addActionListener(
                e -> {
                    addPeopleViewModel.getState().setProject(project);
                    viewManagerModel.setActiveView(addPeopleViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        JPanel title = new JPanel();
        title.setLayout(new BoxLayout(title, BoxLayout.Y_AXIS));
        title.add(projectName);
        title.add(description);
        projectName.setAlignmentX(CENTER_ALIGNMENT);
        projectName.setFont(new Font(projectName.getFont().getName(), Font.BOLD, 32));
        description.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(author);
        author.setAlignmentX(CENTER_ALIGNMENT);
        this.add(Box.createVerticalGlue());
        this.add(addSomePeople);
        buttonField.add(messageBoard);
        buttonField.add(toDoPanel);
        buttonField.add(schedule);
        this.add(buttonField);
        JButton back = new JButtonWithFont("Back");
        back.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(chooseProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        JPanel bottom = new JPanel();
        bottom.add(addSomePeople);
        bottom.add(back);
        this.add(bottom);
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
            ToDoPanelState toDoPanelState = toDoPanelViewModel.getState();
            toDoPanelState.setUser(user);
            toDoPanelState.setProjectID(project.getID());
            toDoPanelState.setToDoPanelID(toDoPanelState.getToDoPanelID());
            toDoPanelState.setCurrentToDoPanel(project.getToDoPanel());
            toDoPanelViewModel.firePropertyChanged(ToDoPanelViewModel.INITIALIZE_TODO_PANEL);
            viewManagerModel.setActiveView(toDoPanelViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        } else if (e.getSource().equals(schedule)) {
            ScheduleState scheduleState = scheduleViewModel.getScheduleState();
            scheduleState.setProjectId(project.getID());
            scheduleState.setScheduleId(project.getSchedule().getId());
            scheduleViewModel.firePropertyChanged(ScheduleViewModel.SCHEDULE_SET_EVENT);
            viewManagerModel.setActiveView(scheduleViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
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
                author.setText("Leader: " + project.getLeader());
                this.repaint();
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
