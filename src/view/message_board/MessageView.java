package view.message_board;

import entities.message.Message;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.message.MessageState;
import interface_adapter.message_board.message.MessageViewModel;
import view.LabelTextPanel;

import javax.swing.*;

public class MessageView {
    private final ViewManagerModel viewManagerModel;
    private final MessageViewModel messageViewModel;
    private final MessageBoardViewModel messageBoardViewModel;
    private final JLabel title;
    private final JLabel auther;
    private final JLabel content;
    private final JTextField addComment = new JTextField();
    private final JPanel commentBoard;

    public MessageView(ViewManagerModel viewManagerModel, MessageViewModel messageViewModel,
                       MessageBoardViewModel messageBoardViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.messageViewModel = messageViewModel;
        this.messageBoardViewModel = messageBoardViewModel;
        MessageState state = messageViewModel.getState();
        Message message = state.getMessage();
        title = new JLabel(message.getTitle());
        auther = new JLabel(message.getAuthor().getName());
        content = new JLabel(message.getContent());

        commentBoard = new JPanel();
    }
}
