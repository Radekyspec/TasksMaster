package use_case.message_board;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.message.Message;

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
        long projectID = messageBoardInputData.projectID();
        long messageBoardID = messageBoardInputData.messageBoardID();
        List<Message> messages = userDataAccessInterface.getMessages(projectID, messageBoardID);
        if (messages == null){
            messageBoardPresenter.prepareGetMessageFailView();
        }else{
            MessageBoardOutputData messageBoardOutputData = new MessageBoardOutputData(messages);
            messageBoardPresenter.prepareGetMessagesSuccessView(messageBoardOutputData);
        }
    }
}
