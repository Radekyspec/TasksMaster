package view.todo;

import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.todo.add_todo.AddToDoState;
import interface_adapter.todo.add_todo.AddToDoController;
import interface_adapter.todo.add_todo.AddToDoViewModel;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_list.add.AddToDoListViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddToDoView extends JPanel implements PropertyChangeListener {
    private final JButton confirm;
    private final JButton cancel;
    private final ToDoListViewModel toDoListViewModel;
    private final JTextField targetInputField = new JTextField();
    private final JPanel targetInfo;
    private final AddToDoViewModel addToDoViewModel;
    private final AddToDoController addToDoController;

    public AddToDoView(ViewManagerModel viewManagerModel,
                       ToDoListViewModel toDoListViewModel,
                       AddToDoViewModel addToDoViewModel,
                       AddToDoController addToDoController) {
        this.toDoListViewModel = toDoListViewModel;
        this.targetInfo = new JPanel();
        this.addToDoViewModel = addToDoViewModel;
        this.addToDoController = addToDoController;
        addToDoViewModel.addPropertyChangeListener(this);

        // View: Title.
        JLabel title = new JLabelWithFont(AddToDoViewModel.ADD_TODO_TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT); // set position of the title.
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title); // add button that u already set.

        JPanel buttons = new JPanel();
        confirm = new JButtonWithFont(AddToDoViewModel.CONFIRM_NEW_TODO_BUTTON_LABEL);
        cancel = new JButtonWithFont(AddToDoViewModel.GO_BACK_BUTTON_LABEL);
        targetInfo.add(new JLabelWithFont(AddToDoViewModel.NAME_IPF));
        buttons.add(confirm);
        buttons.add(cancel);

        targetInputField.addKeyListener(
                new KeyListener() {
                    /**
                     * Invoked when a key has been typed.
                     * See the class description for {@link KeyEvent} for a definition of
                     * a key typed event.
                     *
                     * @param e the event to be processed
                     */
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    /**
                     * Invoked when a key has been pressed.
                     * See the class description for {@link KeyEvent} for a definition of
                     * a key pressed event.
                     *
                     * @param e the event to be processed
                     */
                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    /**
                     * Invoked when a key has been released.
                     * See the class description for {@link KeyEvent} for a definition of
                     * a key released event.
                     *
                     * @param e the event to be processed
                     */
                    @Override
                    public void keyReleased(KeyEvent e) {
                        addToDoViewModel.getState().setTarget(targetInputField.getText());
                    }
                }
        );

        confirm.addActionListener(
                e -> {
                    if (!e.getSource().equals(confirm)) {
                        return;
                    }
                    AddToDoState state = addToDoViewModel.getState();
                    addToDoController.addMainLogic(
                            state.getTarget(),
                            state.getProgress(),
                            state.getToDoListID(),
                            state.getProjectID()
                    );
                }
        );
        cancel.addActionListener(
                e -> {
                    if (!e.getSource().equals(cancel)) {
                        return;
                    }
                    viewManagerModel.setActiveView(toDoListViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        this.add(targetInfo);
        this.add(buttons);
    }
    /**
     * This method gets called when a bound property is changed.
     * FOR VIEW, there is no need for further view, it is already back to ToDoListView.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddToDoState state = (AddToDoState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case AddToDoViewModel.CREATE_TODO -> {
                JOptionPane.showMessageDialog(
                        null,
                        "Create success! \nIt's time to write adding this List into current view! ");
            }
        }
    }
}
