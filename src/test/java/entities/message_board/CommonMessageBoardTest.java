package entities.message_board;

import entities.message.CommonMessageFactory;
import entities.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonMessageBoardTest {
    private MessageBoard messageBoard;
    private Message message;

    @BeforeEach
    void setUp() {
        messageBoard = CommonMessageBoardFactory.create(1);
        message = CommonMessageFactory.create(1, "Sawyer", "Project", "Project due day is December 4th!");
    }

    @Test
    void getID() {
        assertEquals(1, messageBoard.getID());
    }

    @Test
    void getSetMessage() {
        assertEquals(0, messageBoard.getMessage().size());
        messageBoard.setMessage(message);
        assertEquals(1, messageBoard.getMessage().size());
        assertEquals(message, messageBoard.getMessage().get(1L));
    }
}