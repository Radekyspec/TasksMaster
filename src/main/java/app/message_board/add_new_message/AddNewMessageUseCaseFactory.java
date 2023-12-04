package app.message_board.add_new_message;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.add_new_message.AddNewMessageController;
import interface_adapter.message_board.add_new_message.AddNewMessagePresenter;
import interface_adapter.message_board.add_new_message.AddNewMessageViewModel;
import use_case.message_board.add_new_message.AddNewMessageInputBoundary;
import use_case.message_board.add_new_message.AddNewMessageInteractor;
import use_case.message_board.add_new_message.AddNewMessageOutputBoundary;
import view.message_board.AddNewMessageView;

public class AddNewMessageUseCaseFactory {
    private AddNewMessageUseCaseFactory() {
    }

    public static AddNewMessageView create(ViewManagerModel viewManagerModel, AddNewMessageViewModel addNewMessageViewModel, MessageBoardViewModel messageBoardViewModel, MessageBoardUserDataAccessInterface messageBoardUserDataAccessInterface) {
        return new AddNewMessageView(viewManagerModel, addNewMessageViewModel, messageBoardViewModel, AddNewMessageUseCaseFactory.createController(viewManagerModel, messageBoardViewModel, messageBoardUserDataAccessInterface));
    }

    public static AddNewMessageController createController(ViewManagerModel viewManagerModel, MessageBoardViewModel messageBoardViewModel, MessageBoardUserDataAccessInterface messageBoardUserDataAccessInterface) {
        AddNewMessageOutputBoundary addNewMessagePresenter = new AddNewMessagePresenter(viewManagerModel, messageBoardViewModel);
        AddNewMessageInputBoundary addNewMessageInteractor = new AddNewMessageInteractor(messageBoardUserDataAccessInterface, addNewMessagePresenter);
        return new AddNewMessageController(addNewMessageInteractor);
    }
}
