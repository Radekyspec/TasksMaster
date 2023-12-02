package view.message_board;

import entities.comment.Comment;
import entities.message.Message;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.message.MessageController;
import interface_adapter.message_board.message.MessageState;
import interface_adapter.message_board.message.MessageViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MessageView extends JPanel implements ActionListener, PropertyChangeListener {
    private User user;
    private final ViewManagerModel viewManagerModel;
    private final MessageViewModel messageViewModel;
    private final MessageBoardViewModel messageBoardViewModel;
    private final MessageController messageController;
    private final JLabel title;
    private final JLabel auther;
    private final JLabel content;
    private final JTextField addComment = new JTextField();
    private final JPanel addCommentPanel = new JPanel();
    private final JButton addThisComment = new JButton();
    private final JPanel commentBoard;

    public MessageView(ViewManagerModel viewManagerModel, MessageViewModel messageViewModel,
                       MessageBoardViewModel messageBoardViewModel, MessageController messageController) {
        this.viewManagerModel = viewManagerModel;
        this.messageViewModel = messageViewModel;
        this.messageBoardViewModel = messageBoardViewModel;
        this.messageController = messageController;
        MessageState state = messageViewModel.getState();
        Message message = state.getMessage();
        title = new JLabel(message.getTitle());
        auther = new JLabel(message.getAuthor());
        content = new JLabel(message.getContent());

        commentBoard = new JPanel();
        MessageState messageState = messageViewModel.getState();
        messageController.getComments(messageState.getProjectID(), messageState.getMessageID());

        addCommentPanel.add(new JLabel("Add a comment here"));
        addCommentPanel.add(addComment);
        addComment.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        messageViewModel.getState().setNewComment(addComment.getText());
                    }
                }
        );
        addCommentPanel.add(addThisComment);
        addThisComment.addActionListener(
                e -> {
                    if (!e.getSource().equals(addThisComment)){
                        return;
                    }
                    MessageState messagestate = new MessageState();

                    messageController.addNewComment(messagestate.getProjectID(), messagestate.getMessageID(), user, messagestate.getNewComment());
                }
        );
        this.add(title);
        this.add(auther);
        this.add(content);
        this.add(commentBoard);
        this.add(addCommentPanel);
        this.add(addThisComment);
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
        switch (evt.getPropertyName()){
            case MessageViewModel.SET_MESSAGE -> {
            }
            case MessageViewModel.ADD_COMMENT -> {
                MessageState state = (MessageState) evt.getNewValue();
                Comment comment = state.getComment();
                commentBoard.add(new JLabel(comment.getAuthor() + comment.getContent()));
            }
        }
    }
}
