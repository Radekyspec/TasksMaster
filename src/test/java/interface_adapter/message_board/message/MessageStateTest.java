package interface_adapter.message_board.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MessageStateTest {
    private MessageState state;

    @BeforeEach
    void setUp() {
        state = new MessageState();
    }

    @Test
    void getNewComment() {
        assertNull(state.getComment());
    }

    @Test
    void setNewComment() {
        state.setNewComment(null);
    }

    @Test
    void getMessage() {
        assertNull(state.getMessage());
    }

    @Test
    void setMessage() {
        state.setMessage(null);
    }

    @Test
    void getComment() {
        assertNull(state.getComment());
    }

    @Test
    void setComment() {
        state.setComment(null);
    }

    @Test
    void getProjectID() {
        assertEquals(0, state.getProjectID());
    }

    @Test
    void getMessageID() {
        assertEquals(0, state.getMessageID());
    }

    @Test
    void setProjectID() {
        state.setProjectID(0);
    }

    @Test
    void setMessageID() {
        state.setMessageID(0);
    }

    @Test
    void getUser() {
        assertNull(state.getUser());
    }

    @Test
    void setUser() {
        state.setUser(null);
    }
}