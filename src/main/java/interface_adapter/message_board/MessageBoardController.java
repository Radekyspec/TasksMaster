package interface_adapter.message_board;

import use_case.message_board.MessageBoardInputBoundary;
import use_case.message_board.MessageBoardInputData;

public class MessageBoardController {
    final MessageBoardInputBoundary messageBoardInteractor;

    public MessageBoardController(MessageBoardInputBoundary messageBoardInteractor) {
        this.messageBoardInteractor = messageBoardInteractor;
    }

    public void getMessages(long projectID, long messageBoardID) {
        MessageBoardInputData messageBoardInputData = new MessageBoardInputData(projectID, messageBoardID);
        messageBoardInteractor.getMessages(messageBoardInputData);
    }

}
