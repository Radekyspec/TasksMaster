package interface_adapter.message_board.message;

import entities.comment.Comment;
import entities.message.Message;
import entities.user.User;

public class MessageState {
    private User user;
    private Message message;
    private String newComment;
    private Comment comment;
    private long projectID;
    private long messageID;

    public String getNewComment() {
        return newComment;
    }

    public void setNewComment(String newComment) {
        this.newComment = newComment;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public long getProjectID() {
        return projectID;
    }

    public long getMessageID() {
        return messageID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public void setMessageID(long messageID) {
        this.messageID = messageID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
