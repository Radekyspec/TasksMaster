package interface_adapter.message_board.message;

import entities.message.Message;

public class MessageState {
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
