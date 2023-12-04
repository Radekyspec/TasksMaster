package view.message_board;

import entities.message.Message;
import entities.message_board.MessageBoard;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardController;
import interface_adapter.message_board.MessageBoardState;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.add_new_message.AddNewMessageState;
import interface_adapter.message_board.add_new_message.AddNewMessageViewModel;
import interface_adapter.message_board.message.MessageState;
import interface_adapter.message_board.message.MessageViewModel;
import interface_adapter.project.MainProjectViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class MessageBoardView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final MainProjectViewModel mainProjectViewModel;
    private final MessageBoardViewModel messageBoardViewModel;
    private final AddNewMessageViewModel addNewMessageViewModel;
    private final MessageViewModel messageViewModel;
    private final MessageBoardController messageBoardController;
    private final JButton addNewMessage;
    private final JPanel messages;
    private final Map<JButton, Message> buttonToMessage;
    private long projectID;
    private long messageBoardID;
    private MessageBoard messageBoard;
    private User user;

    public MessageBoardView(ViewManagerModel viewManagerModel, MainProjectViewModel mainProjectViewModel, MessageBoardViewModel messageBoardViewModel,
                            AddNewMessageViewModel addNewMessageViewModel, MessageViewModel messageViewModel,
                            MessageBoardController messageBoardController) {
        this.viewManagerModel = viewManagerModel;
        this.mainProjectViewModel = mainProjectViewModel;
        this.messageBoardViewModel = messageBoardViewModel;
        this.addNewMessageViewModel = addNewMessageViewModel;
        this.messageViewModel = messageViewModel;
        this.messageBoardController = messageBoardController;
        buttonToMessage = new HashMap<>();
        messageBoardViewModel.addPropertyChangeListener(this);

        messages = new JPanel();
        messages.setLayout(new BoxLayout(messages, BoxLayout.Y_AXIS));

        addNewMessage = new JButtonWithFont(MessageBoardViewModel.ADD_NEW_MESSAGE_LABEL);
        addNewMessage.addActionListener(
                e -> {
                    if (!e.getSource().equals(addNewMessage)) {
                        return;
                    }
                    viewManagerModel.setActiveView(addNewMessageViewModel.getViewName());
                    AddNewMessageState addNewMessageState = addNewMessageViewModel.getAddNewMessageState();
                    addNewMessageState.setProjectID(messageBoardViewModel.getMessageBoardState().getProjectID());
                    addNewMessageState.setMessageBoardID(messageBoardViewModel.getMessageBoardState().getMessageBoardID());
                    addNewMessageState.setAuthor(user);
                    viewManagerModel.firePropertyChanged();
                }
        );
        JButton back = new JButtonWithFont("Back");
        back.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        JLabel title = new JLabelWithFont(MessageBoardViewModel.MESSAGE_BOARD_TITLE_LABEL, Font.BOLD, 32);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(title);
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabelWithFont messageHere = new JLabelWithFont("Messages Here", Font.BOLD, 32);
        messageHere.setAlignmentX(CENTER_ALIGNMENT);
        this.add(Box.createVerticalGlue());
        this.add(messageHere);
        this.add(Box.createVerticalGlue());
        this.add(messages);
        this.add(Box.createVerticalGlue());
        JPanel bottom = new JPanel();
        bottom.add(addNewMessage);
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
        Message message = buttonToMessage.get((JButton) e.getSource());
        MessageState state = messageViewModel.getState();
        state.setMessage(message);
        state.setProjectID(projectID);
        state.setUser(user);
        messageViewModel.firePropertyChanged(MessageViewModel.SET_MESSAGE);
        viewManagerModel.setActiveView(messageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MessageBoardState state = (MessageBoardState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case MessageBoardViewModel.SET_USER_PROJECT -> {
                this.user = state.getUser();
                this.projectID = state.getProjectID();
                this.messageBoard = state.getMessageBoard();
                this.messageBoardID = state.getMessageBoardID();
                messages.removeAll();
                messageBoardController.getMessages(projectID, messageBoardID);
            }
            case MessageBoardViewModel.ADD_NEW_MESSAGE_LABEL -> {
                Message message = state.getMessage();
                JButton messageButton = new JButtonWithFont(message.getAuthor() + ": " + message.getTitle());
                messageButton.setAlignmentX(CENTER_ALIGNMENT);
                messageBoard.setMessage(message);
                buttonToMessage.put(messageButton, message);
                messageButton.addActionListener(this);
                messageButton.setPreferredSize(new Dimension(100, 35));
                messages.add(messageButton);
            }
        }
    }

    public String getViewName() {
        return messageBoardViewModel.getViewName();
    }
}
