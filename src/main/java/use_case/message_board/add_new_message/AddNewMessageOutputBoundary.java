package use_case.message_board.add_new_message;

public interface AddNewMessageOutputBoundary {
    void prepareSuccessView(AddNewMessageOutputData addNewMessageOutputData);

    void prepareFailView();
}
