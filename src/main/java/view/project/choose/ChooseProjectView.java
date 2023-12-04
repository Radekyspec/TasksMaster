package view.project.choose;

import entities.project.Project;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectController;
import interface_adapter.project.choose.ChooseProjectState;
import interface_adapter.project.choose.ChooseProjectViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ChooseProjectView extends JPanel implements PropertyChangeListener, ActionListener {
    private final ChooseProjectViewModel chooseProjectViewModel;
    private final ChooseProjectController chooseProjectController;
    private final JButton enter;
    private final JComboBox<String> projectList;
    private final List<Project> projects;
    private User user;

    public ChooseProjectView(ViewManagerModel viewManagerModel, AddProjectViewModel addProjectViewModel,
                             ChooseProjectViewModel chooseProjectViewModel, ChooseProjectController chooseProjectController) {
        this.chooseProjectViewModel = chooseProjectViewModel;
        this.chooseProjectController = chooseProjectController;
        chooseProjectViewModel.addPropertyChangeListener(this);

        projects = new ArrayList<>();
        projectList = new JComboBox<>();
        JPanel buttons = new JPanel();
        JPanel chooseProjectPanel = new JPanel();
        projectList.setFont(new Font("Times New Roman", Font.PLAIN, 26));

        chooseProjectPanel.add(new JLabelWithFont(ChooseProjectViewModel.CHOOSE_YOUR_PROJECT));
        chooseProjectPanel.add(projectList);
        JButton create = new JButtonWithFont(ChooseProjectViewModel.BUTTON_CREATE_PROJECT_LABEL);
        create.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(addProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        enter = new JButtonWithFont(ChooseProjectViewModel.BUTTON_ENTER_PROJECT_LABEL);
        enter.addActionListener(this);
        buttons.add(enter);
        buttons.add(create);
        JLabel title = new JLabelWithFont(ChooseProjectViewModel.CHOOSE_PROJECT_LABEL, Font.BOLD, 32);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(chooseProjectPanel);
        this.add(buttons);
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ChooseProjectState state = (ChooseProjectState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case ChooseProjectViewModel.UPDATE_PROJECT -> {
                projectList.addItem(state.getProject().getName());
                projects.add(state.getProject());
            }
            case ChooseProjectViewModel.SET_USER -> {
                this.user = state.getUser();
                chooseProjectController.getUserProjects(user);
            }
            case ChooseProjectViewModel.CHOOSE_PROJECT_ERROR -> {
                if (state.getChooseProjectError() != null) {
                    JOptionPane.showMessageDialog(this, state.getChooseProjectError());
                    state.setChooseProjectError(null);
                }
            }
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getSource().equals(enter)) {
            return;
        }
        chooseProjectController.execute(projects.get(projectList.getSelectedIndex()));
    }

    public String getViewName() {
        return chooseProjectViewModel.getViewName();
    }
}
