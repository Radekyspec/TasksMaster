package view.todo_list;

import interface_adapter.ViewManagerModel;
import interface_adapter.todo_list.ToDoListViewModel;
import interface_adapter.todo_list.add.AddToDoListController;
import interface_adapter.todo_list.add.AddToDoListState;
import interface_adapter.todo_list.add.AddToDoListViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddToDoListView extends JPanel implements PropertyChangeListener {
    private final ToDoPanelViewModel toDoPanelViewModel;
    private final AddToDoListViewModel addToDoListViewModel;
    private final AddToDoListController addToDoListController;
    private final JTextField detailInputField = new JTextField(30);
    private final JPanel nameInfo;
    private final JPanel contentInfo;
    private JButton confirm;
    private JButton cancel;
    private final JTextField nameInputField = new JTextField(15);
    public AddToDoListView(ViewManagerModel viewManagerModel,
                           ToDoPanelViewModel toDoPanelViewModel,
                           AddToDoListViewModel addToDoListViewModel,
                           AddToDoListController addToDoListController) {
        this.toDoPanelViewModel = toDoPanelViewModel;
        this.addToDoListViewModel = addToDoListViewModel;
        this.addToDoListController = addToDoListController;
        addToDoListViewModel.addPropertyChangeListener(this);
        this.nameInfo = new JPanel();
        this.contentInfo = new JPanel();

        // View: Title.
        JLabel title = new JLabelWithFont(AddToDoListViewModel.ADD_TODO_LIST_TITLE_LABEL, Font.BOLD, 32);
        title.setAlignmentX(CENTER_ALIGNMENT); // set position of the title.
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(title); // add button that u already set.
        this.add(Box.createVerticalGlue());

        JPanel buttons = new JPanel();
        confirm = new JButtonWithFont(AddToDoListViewModel.ADD_NEW_TODO_BUTTON_LABEL);
        cancel = new JButtonWithFont(AddToDoListViewModel.GO_BACK_BUTTON_LABEL);
        nameInfo.add(new JLabelWithFont(AddToDoListViewModel.NAME_IPF));
        nameInfo.add(nameInputField);
        nameInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        contentInfo.add(new JLabelWithFont(AddToDoListViewModel.DETAIL_IPF));
        contentInfo.add(detailInputField);
        detailInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        buttons.add(confirm);
        buttons.add(cancel);

        nameInputField.addKeyListener(
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
                        addToDoListViewModel.getState().setName(nameInputField.getText());
                    }
                }
        );

        detailInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        addToDoListViewModel.getState().setDetail(detailInputField.getText());
                    }
                }
        );

        confirm.addActionListener(
                e -> {
                    if (!e.getSource().equals(confirm)) {
                        return;
                    }

                    AddToDoListState state = addToDoListViewModel.getState();
                    addToDoListController.mainLogic(state.getName(), state.getDetail(), state.getToDoPanelID(), state.getProjectID());
                    viewManagerModel.setActiveView(toDoPanelViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        cancel.addActionListener(
                e -> {
                    if (!e.getSource().equals(cancel)) {
                        return;
                    }
                    viewManagerModel.setActiveView(toDoPanelViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        this.add(nameInfo);
        this.add(Box.createVerticalGlue());
        this.add(contentInfo);
        this.add(Box.createVerticalGlue());
        this.add(buttons);
    }

    /**
     * (general) This method gets called when a bound property is changed.
     * If or if not adding succeed or failed, AddToDoListView only shows different dialogs.
     * FOR VIEW, there is no need for further view, it is already back to ToDoPanelView.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddToDoListState state = (AddToDoListState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case AddToDoListViewModel.CREATE_TODO_LIST_FAILED -> JOptionPane.showMessageDialog(
                    this,
                    AddToDoListViewModel.CREATE_TODO_LIST_FAILED
            );
        }
    }

    public String getViewName() {
        return addToDoListViewModel.getViewName();
    }
}
