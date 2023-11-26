package interface_adapter.message_board;

import entities.message.Message;
import use_case.message_board.MessageBoardOutpuBoundary;
import use_case.message_board.MessageBoardOutputData;

public class MessageBoardPresenter implements MessageBoardOutpuBoundary {
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
            messageBoardViewModel.firePropertyChanged();
        }
    }
}
