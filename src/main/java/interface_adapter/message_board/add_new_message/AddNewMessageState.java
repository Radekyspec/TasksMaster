package interface_adapter.message_board.add_new_message;

import entities.user.User;

public class AddNewMessageState {
    private long projectID;
    private long messageBoardID;
    private String messageTitle;
    private String messageContent;
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public long getMessageBoardID() {
        return messageBoardID;
    }

    public void setMessageBoardID(long messageBoardID) {
        this.messageBoardID = messageBoardID;
    }
}
