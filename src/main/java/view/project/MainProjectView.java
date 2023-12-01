package view.project;

import entities.project.Project;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardState;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.project.MainProjectController;
import interface_adapter.project.MainProjectState;
import interface_adapter.project.MainProjectViewModel;
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
    private final MainProjectController mainProjectController;
    private final JLabel projectName = new JLabel();
    private final JLabel description = new JLabel();
    private final JButton addSomePeople = new JButton();
    private final JButton messageBoard = new JButton();
    private final JButton toDoPanel = new JButton();
    private final JButton schedule = new JButton();
    private final JPanel buttonField = new JPanel();

    public MainProjectView(ViewManagerModel viewManagerModel, MainProjectViewModel mainProjectViewModel,
                           MessageBoardViewModel messageBoardViewModel, ToDoPanelViewModel toDoPanelViewModel,
                           MainProjectController mainProjectController) {
        this.viewManagerModel = viewManagerModel;
        this.mainProjectViewModel = mainProjectViewModel;
        this.messageBoardViewModel = messageBoardViewModel;
        this.toDoPanelViewModel = toDoPanelViewModel;
        this.mainProjectController = mainProjectController;

        addSomePeople.addActionListener(
                e -> {

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
            messageBoardViewModel.firePropertyChanged();
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
            case MainProjectViewModel.SET_PROJECT_USER -> {
                project = state.getProject();
                user = state.getUser();
                projectName.setText(project.getName());
                description.setText(project.getDescription());
                messageBoard.addActionListener(this);
                toDoPanel.addActionListener(this);
                schedule.addActionListener(this);
            }
        }
    }
}
