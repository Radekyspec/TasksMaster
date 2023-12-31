package interface_adapter.message_board.add_new_message;

import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import use_case.message_board.add_new_message.AddNewMessageOutputBoundary;
import use_case.message_board.add_new_message.AddNewMessageOutputData;

import javax.swing.*;

public class AddNewMessagePresenter implements AddNewMessageOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final MessageBoardViewModel messageBoardViewModel;

    public AddNewMessagePresenter(ViewManagerModel viewManagerModel, MessageBoardViewModel messageBoardViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.messageBoardViewModel = messageBoardViewModel;
    }

    @Override
    public void prepareSuccessView(AddNewMessageOutputData addNewMessageOutputData) {
        messageBoardViewModel.getMessageBoardState().setMessage(addNewMessageOutputData.getMessage());
        messageBoardViewModel.firePropertyChanged(MessageBoardViewModel.ADD_NEW_MESSAGE_LABEL);
        viewManagerModel.setActiveView(messageBoardViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        JOptionPane.showMessageDialog(null, "error");
    }
}
