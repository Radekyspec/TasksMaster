package interface_adapter.message_board;

import entities.message.Message;

import java.util.List;

public class MessageBoardState {
    private Message message;
    private final int projectID;
    private final int messageBoardID;

    public MessageBoardState(int projectID, int messageBoardID) {
        this.projectID = projectID;
        this.messageBoardID = messageBoardID;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getMessageBoardID() {
        return messageBoardID;
    }

    public Message getMessage() {
        return message;
    }
    public void setMessage(Message message) {
        this.message = message;
    }

}
