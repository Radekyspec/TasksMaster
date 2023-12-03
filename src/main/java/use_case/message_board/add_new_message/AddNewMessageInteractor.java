package use_case.message_board.add_new_message;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.message.Message;
import entities.user.User;

public class AddNewMessageInteractor implements AddNewMessageInputBoundary{
    final MessageBoardUserDataAccessInterface userDataAccessInterface;
    final AddNewMessageOutputBoundary addNewMessagePresenter;

    public AddNewMessageInteractor(MessageBoardUserDataAccessInterface userDataAccessInterface,
                                   AddNewMessageOutputBoundary addNewMessagePresenter) {
        this.userDataAccessInterface = userDataAccessInterface;
        this.addNewMessagePresenter = addNewMessagePresenter;
    }

    @Override
    public void postMessage(AddNewMessageInputData addNewMessageInputData) {
        long projectID = addNewMessageInputData.getProjectID();
        long messageBoardID = addNewMessageInputData.getMessageBoardID();
        User author = addNewMessageInputData.getAuthor();
        String messageTitle = addNewMessageInputData.getMessageTitle();
        String messageContent = addNewMessageInputData.getMessageContent();
        Message message = userDataAccessInterface.addMessage(projectID, messageBoardID, author,
                messageTitle, messageContent);
        AddNewMessageOutputData addNewMessageOutputData = new AddNewMessageOutputData(message);
        addNewMessagePresenter.prepareSuccessView(addNewMessageOutputData);
    }
}
