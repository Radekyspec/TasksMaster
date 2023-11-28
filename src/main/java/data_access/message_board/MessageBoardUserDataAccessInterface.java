package data_access.message_board;

import entities.comment.Comment;
import entities.message.Message;
import entities.user.User;

import java.util.List;

public interface MessageBoardUserDataAccessInterface {
    List<Message> getMessages(int projectID, int messageBoardID);

    List<Comment> getComments(int projectID, int messageID);

    Comment addComment(int projectID, int messageID, User user, String newComment);

    Message addMessage(int projectID, int messageBoardID, User author, String messageTitle, String messageContent);
}
