package view.project.choose;

import entities.user.User;
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
    private final JComboBox<JLabel> projectList;
    private final List<Integer> projectIds;

    public ChooseProjectView(
            ChooseProjectViewModel chooseProjectViewModel, ChooseProjectController chooseProjectController) {
        this.chooseProjectViewModel = chooseProjectViewModel;
        this.chooseProjectController = chooseProjectController;
        chooseProjectViewModel.addPropertyChangeListener(this);

        projectIds = new ArrayList<>();
        projectList = new JComboBox<>();
        enter = new JButton(ChooseProjectViewModel.BUTTON_ENTER_PROJECT_LABEL);
        enter.addActionListener(this);
        JLabel title = new JLabel(ChooseProjectViewModel.CHOOSE_PROJECT_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(enter);
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
                projectList.add(new JLabel(state.getProject().getName()));
                projectIds.add(state.getProject().getID());
            }
            case ChooseProjectViewModel.SET_USER -> {
                this.user = (User) evt.getNewValue();
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
        if (!e.getSource().equals(enter)) {return;}
        chooseProjectController.execute(projectIds.get(projectList.getSelectedIndex()));
    }
}
