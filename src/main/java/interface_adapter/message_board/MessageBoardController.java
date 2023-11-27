package main.java.interface_adapter.message_board;

import main.java.use_case.message_board.MessageBoardInputBoundary;
import main.java.use_case.message_board.MessageBoardInputData;

public class MessageBoardController {
    final MessageBoardInputBoundary messageBoardInteractor;

    public MessageBoardController(MessageBoardInputBoundary messageBoardInteractor) {
        this.messageBoardInteractor = messageBoardInteractor;
    }

    public void getMessages(int projectID, int messageBoardID) {
        MessageBoardInputData messageBoardInputData = new MessageBoardInputData(projectID, messageBoardID);
        messageBoardInteractor.getMessages(messageBoardInputData);
    }

}
