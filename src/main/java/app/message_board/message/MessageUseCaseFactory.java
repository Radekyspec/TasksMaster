package app.message_board.message;


import data_access.message_board.MessageBoardUserDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.message.MessageController;
import interface_adapter.message_board.message.MessagePresenter;
import interface_adapter.message_board.message.MessageViewModel;
import use_case.message_board.message.MessageInputBoundary;
import use_case.message_board.message.MessageInteractor;
import use_case.message_board.message.MessageOutputBoundary;
import view.message_board.MessageView;

public class MessageUseCaseFactory {
    private MessageUseCaseFactory(){

    }

    public static MessageView create(ViewManagerModel viewManagerModel, MessageViewModel messageViewModel, MessageBoardViewModel messageBoardViewModel, MessageController messageController){
        return new MessageView(viewManagerModel, messageViewModel, messageBoardViewModel, messageController);
    }

    public static MessageController createController(MessageViewModel messageViewModel, MessageBoardUserDataAccessInterface messageBoardUserDataAccessInterface){
        MessageOutputBoundary messagePresenter = new MessagePresenter(messageViewModel);
        MessageInputBoundary messageInteractor = new MessageInteractor(messageBoardUserDataAccessInterface, messagePresenter);
        return new MessageController(messageInteractor);
    }
}
