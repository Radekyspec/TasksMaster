package interface_adapter.message_board;

import entities.message.Message;
import use_case.message_board.MessageBoardOutputBoundary;
import use_case.message_board.MessageBoardOutputData;

import javax.swing.*;

public class MessageBoardPresenter implements MessageBoardOutputBoundary {
    private final MessageBoardViewModel messageBoardViewModel;

    public MessageBoardPresenter(MessageBoardViewModel messageBoardViewModel) {
        this.messageBoardViewModel = messageBoardViewModel;
    }

    /**
     * @param messageBoardOutputData
     */
    @Override
    public void prepareGetMessagesSuccessView(MessageBoardOutputData messageBoardOutputData) {
        for (Message message : messageBoardOutputData.getMessages()) {
            messageBoardViewModel.getMessageBoardState().setMessage(message);
            messageBoardViewModel.firePropertyChanged(MessageBoardViewModel.ADD_NEW_MESSAGE_LABEL);
        }
    }

    @Override
    public void prepareGetMessageFailView() {
        JOptionPane.showMessageDialog(null, MessageBoardViewModel.NO_MESSAGE);
    }
}
