package interface_adapter.message_board;

import entities.message.Message;
import entities.message_board.MessageBoard;
import entities.project.Project;
import entities.user.User;

public class MessageBoardState {
    private Project project;
    private MessageBoard messageBoard;
    private User user;
    private Message message;
    private int projectID;
    private int messageBoardID;

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setMessageBoardID(int messageBoardID) {
        this.messageBoardID = messageBoardID;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getMessageBoardID() {
        return messageBoardID;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MessageBoard getMessageBoard() {
        return messageBoard;
    }

    public void setMessageBoard(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
