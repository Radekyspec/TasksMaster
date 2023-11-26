package use_case.message_board;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.message.Message;

import java.util.List;

public class MessageBoardInteractor implements MessageBoardInputBoundary{
    final MessageBoardUserDataAccessInterface userDataAccessInterface;
    final MessageBoardOutpuBoundary messageBoardPresenter;


    public MessageBoardInteractor(MessageBoardUserDataAccessInterface userDataAccessInterface,
                                  MessageBoardOutpuBoundary messageBoardPresenter) {
        this.userDataAccessInterface = userDataAccessInterface;
        this.messageBoardPresenter = messageBoardPresenter;
    }

    /**
     * @param messageBoardInputData
     */
    @Override
    public void getMessages(MessageBoardInputData messageBoardInputData) {
        int projectID = messageBoardInputData.projectID();
        int MessageBoardID = messageBoardInputData.messageBoardID();
        List<Message> messages = userDataAccessInterface.getMessages();
        MessageBoardOutputData messageBoardOutputData = new MessageBoardOutputData(messages);
        messageBoardPresenter.prepareGetMessagesSuccessView(messageBoardOutputData);
    }
}
