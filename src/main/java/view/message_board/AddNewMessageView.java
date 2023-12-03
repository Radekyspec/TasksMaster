package view.message_board;

import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.add_new_message.AddNewMessageController;
import interface_adapter.message_board.add_new_message.AddNewMessageState;
import interface_adapter.message_board.add_new_message.AddNewMessageViewModel;
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

public class AddNewMessageView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final AddNewMessageViewModel addNewMessageViewModel;
    private final MessageBoardViewModel messageBoardViewModel;
    private final AddNewMessageController addNewMessageController;
    private final JTextField titleInputField = new JTextField(15);
    private final JTextField contentInputField = new JTextField(15);

    public AddNewMessageView(ViewManagerModel viewManagerModel, AddNewMessageViewModel addNewMessageViewModel,
                             MessageBoardViewModel messageBoardViewModel, AddNewMessageController addNewMessageController) {
        this.viewManagerModel = viewManagerModel;
        this.addNewMessageViewModel = addNewMessageViewModel;
        this.messageBoardViewModel = messageBoardViewModel;
        this.addNewMessageController = addNewMessageController;
        JPanel titleInfo = new JPanel();
        titleInfo.add(new JLabelWithFont(AddNewMessageViewModel.TYPE_TITLE_MESSAGE));
        titleInfo.add(titleInputField);
        titleInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        JPanel contentInfo = new JPanel();
        contentInfo.add(new JLabelWithFont(AddNewMessageViewModel.TYPE_CONTENT));
        contentInfo.add(contentInputField);
        contentInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
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

        JButton postButton = new JButtonWithFont(AddNewMessageViewModel.POST_THIS);
        postButton.addActionListener(
                e -> {
                    AddNewMessageState state = addNewMessageViewModel.getAddNewMessageState();
                    addNewMessageController.postMessage(state.getProjectID(), state.getMessageBoardID(),
                            state.getAuthor(), state.getMessageTitle(), state.getMessageContent());
                }
        );
        JButtonWithFont back = new JButtonWithFont("Back");
        back.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(messageBoardViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabelWithFont title = new JLabelWithFont(AddNewMessageViewModel.TITLE, Font.BOLD, 26);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createVerticalGlue());
        this.add(titleInfo);
        this.add(contentInfo);
        JPanel bottom = new JPanel();
        bottom.add(postButton);
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
        return addNewMessageViewModel.getViewName();
    }
}
