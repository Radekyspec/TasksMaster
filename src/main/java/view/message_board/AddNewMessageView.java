package view.message_board;

import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.add_new_message.AddNewMessageController;
import interface_adapter.message_board.add_new_message.AddNewMessageState;
import interface_adapter.message_board.add_new_message.AddNewMessageViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddNewMessageView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final AddNewMessageViewModel addNewMessageViewModel;
    private final AddNewMessageController addNewMessageController;
    private final JPanel titleInfo = new JPanel();
    private final JTextField titleInputField = new JTextField();
    private final JPanel contentInfo = new JPanel();
    private final JTextField contentInputField = new JTextField();
    private final JButton postButton;

    public AddNewMessageView(ViewManagerModel viewManagerModel, AddNewMessageViewModel addNewMessageViewModel,
                             AddNewMessageController addNewMessageController) {
        this.viewManagerModel = viewManagerModel;
        this.addNewMessageViewModel = addNewMessageViewModel;
        this.addNewMessageController = addNewMessageController;
        titleInfo.add(new JLabelWithFont(addNewMessageViewModel.TYPE_TITLE_MESSAGE), titleInputField);
        contentInfo.add(new JLabelWithFont(addNewMessageViewModel.TYPE_CONTENT), contentInputField);
        titleInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        addNewMessageViewModel.getAddNewMessageState().setMessageTitle(titleInputField.getText());
                    }
        });

        contentInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        addNewMessageViewModel.getAddNewMessageState().setMessageContent(contentInputField.getText());
                    }
                }
        );

        postButton = new JButtonWithFont(addNewMessageViewModel.POST_THIS);
        postButton.addActionListener(
                e -> {
                    AddNewMessageState state = addNewMessageViewModel.getAddNewMessageState();
                    addNewMessageController.postMessage(state.getProjectID(), state.getMessageBoardID(),
                            state.getAuthor(), state.getMessageTitle(), state.getMessageContent());
                }
        );

        this.add(titleInfo);
        this.add(contentInfo);
        this.add(postButton);
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
}
