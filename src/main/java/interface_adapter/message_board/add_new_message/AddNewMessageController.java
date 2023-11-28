package interface_adapter.message_board.add_new_message;

import entities.user.User;
import use_case.message_board.add_new_message.AddNewMessageInputBoundary;
import use_case.message_board.add_new_message.AddNewMessageInputData;

public class AddNewMessageController {
    final AddNewMessageInputBoundary addNewMessageUseCaseInteractor;

    public AddNewMessageController(AddNewMessageInputBoundary addNewMessageUseCaseInteractor) {
        this.addNewMessageUseCaseInteractor = addNewMessageUseCaseInteractor;
    }

    public void postMessage(int projectID, int messageBoardID, User author,
                            String messageTitle, String messageContent) {
        AddNewMessageInputData addNewMessageInputData = new AddNewMessageInputData(projectID, messageBoardID, author,
                messageTitle, messageContent);
        addNewMessageUseCaseInteractor.postMessage(addNewMessageInputData);
    }
}
