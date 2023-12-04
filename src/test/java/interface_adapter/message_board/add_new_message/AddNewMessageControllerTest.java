package interface_adapter.message_board.add_new_message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddNewMessageControllerTest {
    private AddNewMessageController addNewMessageController;

    @BeforeEach
    void setUp() {
        addNewMessageController = new AddNewMessageController(addNewMessageInputData -> {});
    }

    @Test
    void postMessage() {
        addNewMessageController.postMessage(0, 0, null, null, null);
    }
}