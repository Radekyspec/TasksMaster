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
    private long projectID;
    private long messageBoardID;

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public void setMessageBoardID(long messageBoardID) {
        this.messageBoardID = messageBoardID;
    }

    public long getProjectID() {
        return projectID;
    }

    public long getMessageBoardID() {
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
