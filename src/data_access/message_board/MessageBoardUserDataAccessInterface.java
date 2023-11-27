package data_access.message_board;

import entities.comment.Comment;
import entities.message.Message;

import java.util.List;

public interface MessageBoardUserDataAccessInterface {
    List<Message> getMessages(int projectID, int messageBoardID);

    List<Comment> getComments(int projectID, int messageID);
}
