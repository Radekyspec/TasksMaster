package use_case.message_board.add_new_message;

import entities.message.Message;

public class AddNewMessageOutputData {
    private final Message message;

    public AddNewMessageOutputData(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
