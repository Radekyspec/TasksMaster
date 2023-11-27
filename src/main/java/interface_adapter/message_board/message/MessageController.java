package main.java.interface_adapter.message_board.message;

import main.java.use_case.message_board.message.MessageInputBoundary;
import main.java.use_case.message_board.message.MessageInputData;

public class MessageController {
    final MessageInputBoundary messageUseCaseInteractor;

    public MessageController(MessageInputBoundary messageUseCaseInteractor) {

        this.messageUseCaseInteractor = messageUseCaseInteractor;
    }

    public void getComments(int projectID, int messageID) {
        MessageInputData messageInputData = new MessageInputData(projectID, messageID);
        messageUseCaseInteractor.getComments(messageInputData);
    }

}
