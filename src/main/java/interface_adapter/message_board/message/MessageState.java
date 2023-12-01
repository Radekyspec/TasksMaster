package interface_adapter.message_board.message;

import entities.comment.Comment;
import entities.message.Message;

public class MessageState {
    private Message message;
    private String newComment;
    private Comment comment;
    private int projectID;
    private int messageID;

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

    public int getProjectID() {
        return projectID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }
}
