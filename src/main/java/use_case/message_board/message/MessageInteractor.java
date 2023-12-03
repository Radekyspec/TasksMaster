package use_case.message_board.message;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.comment.Comment;
import entities.user.User;


import java.util.ArrayList;
import java.util.List;

public class MessageInteractor implements MessageInputBoundary {
    final MessageBoardUserDataAccessInterface userDataAccessInterface;
    final MessageOutputBoundary messagePresenter;

    public MessageInteractor(MessageBoardUserDataAccessInterface userDataAccessInterface,
                             MessageOutputBoundary messagePresenter) {
        this.userDataAccessInterface = userDataAccessInterface;
        this.messagePresenter = messagePresenter;
    }

    @Override
    public void getComments(MessageInputData messageInputData) {
        long projectID = messageInputData.projectID();
        long messageID = messageInputData.messageID();
        List<Comment> comments = userDataAccessInterface.getComments(projectID, messageID);
        MessageOutputData messageOutputData = new MessageOutputData(comments);
        messagePresenter.prepareGetCommentsSuccessView(messageOutputData);
    }

    @Override
    public void addComments(MessageInputData messageInputData) {
        long projectID = messageInputData.projectID();
        long messageID = messageInputData.messageID();
        User user = messageInputData.user();
        String newComment = messageInputData.newComment();
        Comment comment = userDataAccessInterface.addComment(projectID,messageID,user,newComment);
        List<Comment> list = new ArrayList<>();
        list.add(comment);
        MessageOutputData messageOutputData = new MessageOutputData(list);
        messagePresenter.prepareGetCommentsSuccessView(messageOutputData);
    }
}
