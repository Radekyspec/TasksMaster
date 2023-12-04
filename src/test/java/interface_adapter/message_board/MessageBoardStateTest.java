package interface_adapter.message_board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MessageBoardStateTest {
    private MessageBoardState state;

    @BeforeEach
    void setUp() {
        state = new MessageBoardState();
    }

    @Test
    void setProjectID() {
        state.setProjectID(0);
    }

    @Test
    void setMessageBoardID() {
        state.setMessageBoardID(0);
    }

    @Test
    void getProjectID() {
        assertEquals(0, state.getProjectID());
    }

    @Test
    void getMessageBoardID() {
        assertEquals(0, state.getMessageBoardID());
    }

    @Test
    void getProject() {
        assertNull(state.getProject());
    }

    @Test
    void setProject() {
        state.setProject(null);
    }

    @Test
    void getUser() {
        assertNull(state.getUser());
    }

    @Test
    void setUser() {
        state.setUser(null);
    }

    @Test
    void getMessageBoard() {
        assertNull(state.getMessageBoard());
    }

    @Test
    void setMessageBoard() {
        state.setMessageBoard(null);
    }

    @Test
    void getMessage() {
        assertNull(state.getMessage());
    }

    @Test
    void setMessage() {
        state.setMessage(null);
    }
}