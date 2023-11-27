package interface_adapter.message_board.message;

import entities.message.Message;
import use_case.message_board.message.MessageInputBoundary;
import use_case.message_board.message.MessageInputData;

public class MessageController {
    final MessageInputBoundary messageUseCaseInteractor;

    public MessageController(MessageInputBoundary messageUseCaseInteractor) {

        this.messageUseCaseInteractor = messageUseCaseInteractor;
    }

    public void getComments(int projectID, int messageID) {
        MessageInputData messageInputData = new MessageInputData(projectID, messageID);
        messageUseCaseInteractor.getComments(messageInputData);
    }

    public void addNewComment(int projectID, Message message, String newComment) {
    }
}
