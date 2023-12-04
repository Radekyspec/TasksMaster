package view.message_board;

import entities.comment.Comment;
import entities.message.Message;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.message.MessageController;
import interface_adapter.message_board.message.MessageState;
import interface_adapter.message_board.message.MessageViewModel;
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

public class MessageView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final MessageViewModel messageViewModel;
    private final MessageBoardViewModel messageBoardViewModel;
    private final MessageController messageController;
    private final JLabel title;
    private final JLabel auther;
    private final JLabel content;
    private final JTextField addComment = new JTextField(30);
    private final JPanel addCommentPanel = new JPanel();
    private final JButton addThisComment = new JButtonWithFont(MessageViewModel.ADD_COMMENT);
    private final JPanel commentBoard;
    private User user;
    private Message message;

    public MessageView(ViewManagerModel viewManagerModel, MessageViewModel messageViewModel,
                       MessageBoardViewModel messageBoardViewModel, MessageController messageController) {
        this.viewManagerModel = viewManagerModel;
        this.messageViewModel = messageViewModel;
        this.messageBoardViewModel = messageBoardViewModel;
        this.messageController = messageController;
        messageViewModel.addPropertyChangeListener(this);
        title = new JLabelWithFont(Font.BOLD, 26);
        auther = new JLabelWithFont(Font.PLAIN, 22);
        content = new JLabelWithFont();

        commentBoard = new JPanel();
        commentBoard.setPreferredSize(new Dimension(1280, 500));
        commentBoard.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        addCommentPanel.add(new JLabelWithFont("Add a comment here"));
        addCommentPanel.add(addComment);
        addComment.setFont(new Font("Times New Roman", Font.PLAIN, 26));
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
                    if (!e.getSource().equals(addThisComment)) {
                        return;
                    }
                    addComment.setText("");
                    MessageState messagestate = messageViewModel.getState();
                    messageController.addNewComment(messagestate.getProjectID(), message.getID(), user, messagestate.getNewComment());
                }
        );
        JButtonWithFont back = new JButtonWithFont("back");
        back.addActionListener(
                e -> {

                    viewManagerModel.setActiveView(messageBoardViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(title);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.add(auther);
        auther.setAlignmentX(CENTER_ALIGNMENT);
        this.add(content);
        content.setAlignmentX(CENTER_ALIGNMENT);
        this.add(Box.createVerticalGlue());
        this.add(commentBoard);
        this.add(Box.createVerticalGlue());
        this.add(addCommentPanel);
        JPanel bottom = new JPanel();
        bottom.add(addThisComment);
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
        switch (evt.getPropertyName()) {
            case MessageViewModel.SET_MESSAGE -> {
                MessageState state = (MessageState) evt.getNewValue();
                commentBoard.removeAll();
                commentBoard.setLayout(new BoxLayout(commentBoard, BoxLayout.Y_AXIS));
                JLabelWithFont commentBoardTitle = new JLabelWithFont("Comment Board", Font.BOLD, 18);
                commentBoardTitle.setAlignmentX(CENTER_ALIGNMENT);
                commentBoard.add(commentBoardTitle);
                this.user = state.getUser();
                this.message = state.getMessage();
                title.setText(message.getTitle());
                auther.setText("Author: " + message.getAuthor());
                content.setText(message.getContent());
                this.repaint();
                MessageState messageState = messageViewModel.getState();
                messageController.getComments(messageState.getProjectID(), message.getID());
            }
            case MessageViewModel.ADD_COMMENT -> {
                MessageState state = (MessageState) evt.getNewValue();
                Comment comment = state.getComment();
                JLabelWithFont commentContent = new JLabelWithFont("  " + comment.getAuthor() + ": " + comment.getContent() + "  ", 18);
                commentContent.setAlignmentX(CENTER_ALIGNMENT);
                commentBoard.add(commentContent);

                this.revalidate();
            }
        }
    }

    public String getViewName() {
        return messageViewModel.getViewName();
    }
}
