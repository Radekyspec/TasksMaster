package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginStateTest {
    private LoginState state;

    @BeforeEach
    void setUp() {
        state = new LoginState();
    }
    @Test
    void setUsername() {
        state.setUsername("username");
        assertEquals("username", state.getUsername());
    }

    @Test
    void setPassword() {
        state.setPassword("password");
        assertEquals("password", state.getPassword());
    }
}