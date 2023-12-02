package view.project.add_people;

import entities.project.Project;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add_people.AddPeopleController;
import interface_adapter.project.add_people.AddPeopleState;
import interface_adapter.project.add_people.AddPeopleViewModel;

import javax.swing.*;
import java.awt.*;
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
    private final MainProjectViewModel mainProjectViewModel;
    private final AddPeopleController addPeopleController;
    private final JLabel title;
    private final JTextField nameInputField = new JTextField(15);
    private final JButton enter = new JButton(AddPeopleViewModel.ENTER);

    public AddPeopleView(ViewManagerModel viewManagerModel, AddPeopleViewModel addPeopleViewModel, MainProjectViewModel mainProjectViewModel, AddPeopleController addPeopleController) {
        this.viewManagerModel = viewManagerModel;
        this.addPeopleViewModel = addPeopleViewModel;
        this.mainProjectViewModel = mainProjectViewModel;
        this.addPeopleController = addPeopleController;

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

        JButton back = new JButton("Back");
        back.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        JPanel typeYourName = new JPanel();
        JLabel type = new JLabel(AddPeopleViewModel.TYPE_NAME);
        typeYourName.add(type);
        typeYourName.add(nameInputField);
        title = new JLabel(AddPeopleViewModel.ADD_NEW_PEOPLE);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        this.add(title);
        this.add(typeYourName);
        JPanel bottom = new JPanel();
        bottom.add(enter);
        bottom.add(back);
        this.add(bottom);
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
