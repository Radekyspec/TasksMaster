package main.java.interface_adapter.message_board.message;

import main.java.use_case.message_board.message.MessageOutputBoundary;
import main.java.use_case.message_board.message.MessageOutputData;

public class MessagePresenter implements MessageOutputBoundary {
    private final MessageViewModel messageViewModel;

    public MessagePresenter(MessageViewModel messageViewModel) {
        this.messageViewModel = messageViewModel;
    }

    @Override
    public void prepareGetCommentsSuccessView(MessageOutputData messageOutputData) {

    }
}
