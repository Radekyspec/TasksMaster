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

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class MessageBoardView extends JPanel implements ActionListener, PropertyChangeListener {
    private int projectID;
    private int messageBoardID;
    private MessageBoard messageBoard;
    private User user;
    private final ViewManagerModel viewManagerModel;
    private final MessageBoardViewModel messageBoardViewModel;
    private final AddNewMessageViewModel addNewMessageViewModel;
    private final MessageViewModel messageViewModel;
    private final MessageBoardController messageBoardController;
    private final JButton addNewMessage;
    private final JPanel messages;
    private final Map<JButton, Message> buttonToMessage;

    public MessageBoardView(ViewManagerModel viewManagerModel, MessageBoardViewModel messageBoardViewModel,
                            AddNewMessageViewModel addNewMessageViewModel, MessageViewModel messageViewModel,
                            MessageBoardController messageBoardController) {
        this.viewManagerModel = viewManagerModel;
        this.messageBoardViewModel = messageBoardViewModel;
        this.addNewMessageViewModel = addNewMessageViewModel;
        this.messageViewModel = messageViewModel;
        this.messageBoardController = messageBoardController;
        buttonToMessage = new HashMap<>();
        messageBoardViewModel.addPropertyChangeListener(this);

        messages = new JPanel();
        MessageBoardState state = messageBoardViewModel.getMessageBoardState();
        messageBoardController.getMessages(projectID, messageBoardID);


        addNewMessage = new JButton(MessageBoardViewModel.ADD_NEW_MESSAGE_LABEL);
        addNewMessage.addActionListener(
                e -> {
                    if (!e.getSource().equals(addNewMessage)) {
                        return;
                    }
                    viewManagerModel.setActiveView(addNewMessageViewModel.getViewName());
                    AddNewMessageState addNewMessageState = addNewMessageViewModel.getAddNewMessageState();
                    addNewMessageState.setProjectID(messageBoardViewModel.getMessageBoardState().getProjectID());
                    addNewMessageState.setMessageBoardID(messageBoardViewModel.getMessageBoardState().getMessageBoardID());
                    viewManagerModel.firePropertyChanged();
                }
        );

        JLabel title = new JLabel(MessageBoardViewModel.MESSAGE_BOARD_TITLE_LABEL);
        this.add(title);
        this.add(addNewMessage);
        if (messages.getComponentCount() == 0){
            messages.add(new JLabel("There is no message..."));
        }
        this.add(messages);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!buttonToMessage.containsKey((JButton) e.getSource())) {
            return;
        }
        Message message = buttonToMessage.get((JButton) e.getSource());
        MessageState state = messageViewModel.getState();
        state.setMessage(message);
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
            }
        }

        Message message = state.getMessage();
        JButton messageButton = new JButton(message.getAuthor().getName() + message.getTitle());
        messageBoard.setMessage(message);
        buttonToMessage.put(messageButton, message);
        messageButton.addActionListener(this);
        messages.add(messageButton);
    }
}
