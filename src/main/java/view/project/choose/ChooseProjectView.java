package view.project.choose;

import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectController;
import interface_adapter.project.choose.ChooseProjectState;
import interface_adapter.project.choose.ChooseProjectViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ChooseProjectView extends JPanel implements PropertyChangeListener, ActionListener {
    private User user;
    private final ChooseProjectViewModel chooseProjectViewModel;
    private final ChooseProjectController chooseProjectController;
    private final JButton enter;
    private final JComboBox<String> projectList;
    private final List<Integer> projectIds;

    public ChooseProjectView(ViewManagerModel viewManagerModel, AddProjectViewModel addProjectViewModel,
            ChooseProjectViewModel chooseProjectViewModel, ChooseProjectController chooseProjectController) {
        this.chooseProjectViewModel = chooseProjectViewModel;
        this.chooseProjectController = chooseProjectController;
        chooseProjectViewModel.addPropertyChangeListener(this);

        projectIds = new ArrayList<>();
        projectList = new JComboBox<>();
        JPanel buttons = new JPanel();
        JPanel chooseProjectPanel = new JPanel();
        chooseProjectPanel.add(new JLabel(ChooseProjectViewModel.CHOOSE_PROJECT_LABEL));
        chooseProjectPanel.add(projectList);
        JButton create = new JButton(ChooseProjectViewModel.BUTTON_CREATE_PROJECT_LABEL);
        create.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(addProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        chooseProjectController.getUserProjects(user);
        enter = new JButton(ChooseProjectViewModel.BUTTON_ENTER_PROJECT_LABEL);
        enter.addActionListener(this);
        buttons.add(enter);
        buttons.add(create);
        JLabel title = new JLabel(ChooseProjectViewModel.CHOOSE_PROJECT_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
        switch (evt.getPropertyName()) {
            case ChooseProjectViewModel.UPDATE_PROJECT -> {
                ChooseProjectState state = (ChooseProjectState) evt.getNewValue();
                projectList.addItem(state.getProject().getName());
                projectIds.add(state.getProject().getID());
            }
            case ChooseProjectViewModel.SET_USER -> this.user = (User) evt.getNewValue();
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getSource().equals(enter)) {return;}
        chooseProjectController.execute(projectIds.get(projectList.getSelectedIndex()));
    }

    public String getViewName() {
        return chooseProjectViewModel.getViewName();
    }
}
