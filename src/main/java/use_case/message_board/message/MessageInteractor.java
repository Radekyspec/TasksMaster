package main.java.use_case.message_board.message;

import main.java.data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.comment.Comment;

import java.util.List;

public class MessageInteractor implements MessageInputBoundary{
    final MessageBoardUserDataAccessInterface userDataAccessInterface;
    final MessageOutputBoundary messagePresenter;

    public MessageInteractor(MessageBoardUserDataAccessInterface userDataAccessInterface, MessageOutputBoundary messagePresenter) {
        this.userDataAccessInterface = userDataAccessInterface;
        this.messagePresenter = messagePresenter;
    }

    @Override
    public void getComments(MessageInputData messageInputData) {
        int projectID = messageInputData.projectID();
        int messageID = messageInputData.messageID();
        List<Comment> comments = userDataAccessInterface.getComments(projectID,messageID);
        MessageOutputData messageOutputData = new MessageOutputData(comments);
        messagePresenter.prepareGetCommentsSuccessView(messageOutputData);
    }
}