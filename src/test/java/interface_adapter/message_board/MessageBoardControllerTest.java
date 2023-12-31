package interface_adapter.message_board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessageBoardControllerTest {
    private MessageBoardController controller;

    @BeforeEach
    void setUp() {
        controller = new MessageBoardController(messageBoardInputData -> {
        });
    }

    @Test
    void getMessages() {
        controller.getMessages(0, 0);
    }
}