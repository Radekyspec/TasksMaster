package use_case.message_board;

import entities.message.Message;

import java.util.List;

public interface MessageBoardOutpuBoundary {
    void prepareGetMessagesSuccessView(MessageBoardOutputData messageBoardOutputData);
}
