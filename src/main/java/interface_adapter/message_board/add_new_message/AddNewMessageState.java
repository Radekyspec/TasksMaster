package interface_adapter.message_board.add_new_message;

import entities.user.User;

public class AddNewMessageState {
    private int projectID;
    private int messageBoardID;
    private String messageTitle;
    private String messageContent;
    private User author;

    public User getAuthor() {
        return author;
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

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getMessageBoardID() {
        return messageBoardID;
    }

    public void setMessageBoardID(int messageBoardID) {
        this.messageBoardID = messageBoardID;
    }
}
