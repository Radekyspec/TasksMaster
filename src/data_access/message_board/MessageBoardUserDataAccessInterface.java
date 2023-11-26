package data_access.message_board;

import entities.message.Message;

import java.util.List;

public interface MessageBoardUserDataAccessInterface {
    List<Message> getMessages();
}
