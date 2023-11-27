package use_case.message_board;

import entities.message.Message;

import java.util.List;

public class MessageBoardOutputData {
    final List<Message> messages;

    public MessageBoardOutputData(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
