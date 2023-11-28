package interface_adapter.message_board.message;

import entities.comment.Comment;
import use_case.message_board.message.MessageOutputBoundary;
import use_case.message_board.message.MessageOutputData;

public class MessagePresenter implements MessageOutputBoundary {
    private final MessageViewModel messageViewModel;

    public MessagePresenter(MessageViewModel messageViewModel) {
        this.messageViewModel = messageViewModel;
    }

    @Override
    public void prepareGetCommentsSuccessView(MessageOutputData messageOutputData) {
        for (Comment comment : messageOutputData.getComments()){
            messageViewModel.getState().setComment(comment);
            messageViewModel.firePropertyChanged();
        }

    }
}