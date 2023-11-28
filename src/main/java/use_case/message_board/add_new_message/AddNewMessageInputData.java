package use_case.message_board.add_new_message;

import entities.user.User;

public class AddNewMessageInputData {
    private int projectID;
    private int messageBoardID;
    private String messageTitle;
    private String messageContent;
    private User author;

    public AddNewMessageInputData(int projectID, int messageBoardID, User author,
                                  String messageTitle, String messageContent) {
        this.projectID = projectID;
        this.messageBoardID = messageBoardID;
        this.author = author;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
    }

    public User getAuthor() {
        return author;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getMessageBoardID() {
        return messageBoardID;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
