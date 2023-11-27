package use_case.message_board.message;

import use_case.message_board.MessageBoardInputData;

public interface MessageInputBoundary {
    void getComments(MessageInputData messageInputData);
}
