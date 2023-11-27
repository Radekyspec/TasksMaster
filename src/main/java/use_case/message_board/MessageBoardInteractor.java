package use_case.message_board;

import entities.message.Message;
import main.java.data_access.message_board.MessageBoardUserDataAccessInterface;

import java.util.List;

public class MessageBoardInteractor implements MessageBoardInputBoundary {
    final MessageBoardUserDataAccessInterface userDataAccessInterface;
    final MessageBoardOutputBoundary messageBoardPresenter;


    public MessageBoardInteractor(MessageBoardUserDataAccessInterface userDataAccessInterface,
                                  MessageBoardOutputBoundary messageBoardPresenter) {
        this.userDataAccessInterface = userDataAccessInterface;
        this.messageBoardPresenter = messageBoardPresenter;
    }

    /**
     * @param messageBoardInputData
     */
    @Override
    public void getMessages(MessageBoardInputData messageBoardInputData) {
        int projectID = messageBoardInputData.projectID();
        int messageBoardID = messageBoardInputData.messageBoardID();
        List<Message> messages = userDataAccessInterface.getMessages(projectID, messageBoardID);
        MessageBoardOutputData messageBoardOutputData = new MessageBoardOutputData(messages);
        messageBoardPresenter.prepareGetMessagesSuccessView(messageBoardOutputData);
    }
}
