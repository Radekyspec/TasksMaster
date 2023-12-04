package interface_adapter.message_board.add_new_message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AddNewMessageStateTest {
    private AddNewMessageState addNewMessageState;

    @BeforeEach
    void setUp() {
        addNewMessageState = new AddNewMessageState();
    }

    @Test
    void setAuthor() {
        addNewMessageState.setAuthor(null);
    }

    @Test
    void getAuthor() {
        assertNull(addNewMessageState.getAuthor());
    }

    @Test
    void getMessageTitle() {
        assertNull(addNewMessageState.getMessageTitle());
    }

    @Test
    void setMessageTitle() {
        addNewMessageState.setMessageTitle("");
    }

    @Test
    void getMessageContent() {
        assertNull(addNewMessageState.getMessageContent());
    }

    @Test
    void setMessageContent() {
        addNewMessageState.setMessageContent("");
    }

    @Test
    void getProjectID() {
        assertEquals(0, addNewMessageState.getProjectID());
    }

    @Test
    void setProjectID() {
        addNewMessageState.setProjectID(0);
    }

    @Test
    void getMessageBoardID() {
        assertEquals(0, addNewMessageState.getMessageBoardID());
    }

    @Test
    void setMessageBoardID() {
        addNewMessageState.setMessageBoardID(0);
    }
}