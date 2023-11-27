package interface_adapter.message_board;

import entities.message.Message;

public class MessageBoardState {
    private Message message;
    private int projectID;
    private int messageBoardID;

    public MessageBoardState(int projectID, int messageBoardID) {
        this.projectID = projectID;
        this.messageBoardID = messageBoardID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setMessageBoardID(int messageBoardID) {
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
