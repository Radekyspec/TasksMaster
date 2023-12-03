package data_access.message_board;

import entities.comment.Comment;
import entities.message.Message;
import entities.user.User;

import java.util.List;

public interface MessageBoardUserDataAccessInterface {
    List<Message> getMessages(long projectID, long messageBoardID);

    List<Comment> getComments(long projectID, long messageID);

    Comment addComment(long projectID, long messageID, User user, String newComment);

    Message addMessage(long projectID, long messageBoardID, User author, String messageTitle, String messageContent);
}
