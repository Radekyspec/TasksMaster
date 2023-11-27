package interface_adapter.message_board.message;

import entities.message.Message;

public class MessageState {
    private Message message;
    private int projectID;
    private int messageID;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getMessageID() {
        return messageID;
    }
}
