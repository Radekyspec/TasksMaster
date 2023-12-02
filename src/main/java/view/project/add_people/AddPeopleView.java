package view.project.add_people;

import entities.project.Project;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.add_people.AddPeopleController;
import interface_adapter.project.add_people.AddPeopleState;
import interface_adapter.project.add_people.AddPeopleViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddPeopleView extends JPanel implements ActionListener, PropertyChangeListener {
    private Project project;
    private final ViewManagerModel viewManagerModel;
    private final AddPeopleViewModel addPeopleViewModel;
    private final AddPeopleController addPeopleController;
    private final JLabel title;
    private final JPanel typeYourName = new JPanel();
    private final JTextField nameInputField = new JTextField();
    private final JButton enter = new JButton(AddPeopleViewModel.ENTER);

    public AddPeopleView(ViewManagerModel viewManagerModel, AddPeopleViewModel addPeopleViewModel, AddPeopleController addPeopleController) {
        this.viewManagerModel = viewManagerModel;
        this.addPeopleViewModel = addPeopleViewModel;
        this.addPeopleController = addPeopleController;

        title = new JLabel(AddPeopleViewModel.ADD_NEW_PEOPLE);
        typeYourName.add(new JLabel(AddPeopleViewModel.TYPE_NAME));
        typeYourName.add(nameInputField);
        nameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        addPeopleViewModel.getState().setUsername(nameInputField.getText());
                    }
                }
        );
        enter.addActionListener(
                e -> {
                    if (!e.getSource().equals(enter)){
                        return;
                    }
                    AddPeopleState state = addPeopleViewModel.getState();
                    addPeopleController.execute(state.getUsername(), state.getProject());
                }
        );
        this.add(title);
        this.add(typeYourName);
        this.add(enter);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName(){
        return addPeopleViewModel.getViewName();
    }
}
