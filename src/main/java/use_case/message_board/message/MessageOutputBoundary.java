package use_case.message_board.message;

public interface MessageOutputBoundary {
    void prepareGetCommentsSuccessView(MessageOutputData messageOutputData);

    void prepareGetCommentsFailView();

    void prepareAddCommentsFailView();
}
