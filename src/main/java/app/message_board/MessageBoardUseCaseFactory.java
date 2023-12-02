package app.message_board;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardController;
import interface_adapter.message_board.MessageBoardPresenter;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.add_new_message.AddNewMessageViewModel;
import interface_adapter.message_board.message.MessageViewModel;
import use_case.message_board.MessageBoardInputBoundary;
import use_case.message_board.MessageBoardInteractor;
import use_case.message_board.MessageBoardOutputBoundary;
import view.message_board.MessageBoardView;

public class MessageBoardUseCaseFactory {
    private MessageBoardUseCaseFactory(){}

    public static MessageBoardView create(ViewManagerModel viewManagerModel,
                                          MessageBoardViewModel messageBoardViewModel,
                                          AddNewMessageViewModel addNewMessageViewModel,
                                          MessageViewModel messageViewModel,
                                          MessageBoardUserDataAccessInterface messageBoardUserDataAccessInterface){
        return new MessageBoardView(viewManagerModel, messageBoardViewModel, addNewMessageViewModel, messageViewModel,
                MessageBoardUseCaseFactory.createController(messageBoardViewModel, messageBoardUserDataAccessInterface));
    }

    public static MessageBoardController createController(MessageBoardViewModel messageBoardViewModel, MessageBoardUserDataAccessInterface messageBoardUserDataAccessInterface){
        MessageBoardOutputBoundary messageBoardPresenter = new MessageBoardPresenter(messageBoardViewModel);
        MessageBoardInputBoundary messageBoardInteractor = new MessageBoardInteractor(messageBoardUserDataAccessInterface, messageBoardPresenter);
        return new MessageBoardController(messageBoardInteractor);
    }
}
