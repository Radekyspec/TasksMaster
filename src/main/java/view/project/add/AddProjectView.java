package view.project.add;

import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.add.AddProjectController;
import interface_adapter.project.add.AddProjectState;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddProjectView extends JPanel implements ActionListener, PropertyChangeListener {
    private User user;
    private final JTextField projectNameInputField = new JTextField(15);
    private final JTextField descriptionInputField = new JTextField(30);
    private final JButton enter;
    private final JButton cancel;
    private final AddProjectViewModel addProjectViewModel;
    private final AddProjectController addProjectController;

    public AddProjectView(
            ViewManagerModel viewManagerModel, AddProjectViewModel addProjectViewModel,
            AddProjectController addProjectController, ChooseProjectViewModel chooseProjectViewModel) {
        this.addProjectViewModel = addProjectViewModel;
        this.addProjectController = addProjectController;
        addProjectViewModel.addPropertyChangeListener(this);

        JPanel projectNameInfo = new JPanel();
        projectNameInfo.add(new JLabelWithFont(AddProjectViewModel.ADD_PROJECT_NAME_LABEL));
        projectNameInfo.add(projectNameInputField);
        projectNameInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        JPanel descriptionInfo = new JPanel();
        descriptionInfo.add(new JLabelWithFont(AddProjectViewModel.ADD_PROJECT_DESCRIPTION_LABEL));
        descriptionInfo.add(descriptionInputField);
        descriptionInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));

        projectNameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        addProjectViewModel.getState().setName(projectNameInputField.getText());
                    }
                }
        );
        descriptionInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        addProjectViewModel.getState().setDescription(descriptionInputField.getText());
                    }
                }
        );

        JPanel buttons = new JPanel();
        enter = new JButtonWithFont(AddProjectViewModel.BUTTON_ENTER_LABEL);
        cancel = new JButtonWithFont(AddProjectViewModel.BUTTON_CANCEL_LABEL);
        buttons.add(enter);
        buttons.add(cancel);
        enter.addActionListener(this);
        cancel.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(chooseProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        JLabel title = new JLabelWithFont(AddProjectViewModel.ADD_PROJECT_TITLE_LABEL, Font.BOLD, 32);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createVerticalGlue());
        this.add(projectNameInfo);
        this.add(descriptionInfo);
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
        AddProjectState state = (AddProjectState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case AddProjectViewModel.SET_USER -> this.user = state.getUser();
            case AddProjectViewModel.ADD_PROJECT_ERROR -> {
                if (state.getAddError() != null) {
                    JOptionPane.showMessageDialog(this, state.getAddError());
                    state.setAddError(null);
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
        AddProjectState state = addProjectViewModel.getState();
        addProjectController.execute(
                user,
                state.getName(),
                state.getDescription()
        );
    }

    public String getViewName() {return addProjectViewModel.getViewName();}
}
