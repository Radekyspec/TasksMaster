package interface_adapter.signup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SignupStateTest {
    private SignupState state;

    @BeforeEach
    void setUp() {
        state = new SignupState();
    }

    @Test
    void getUsername() {
        assertEquals("", state.getUsername());
    }

    @Test
    void setUsername() {
        state.setUsername("legal");
        state.setUsername("illega|name");
    }

    @Test
    void getUsernameError() {
        assertNull(state.getUsernameError());
    }

    @Test
    void getEmail() {
        assertEquals("", state.getEmail());
    }

    @Test
    void setEmail() {
        state.setEmail("aa@legal.email");
        state.setEmail("illegal");
    }

    @Test
    void getEmailError() {
        assertNull(state.getEmailError());
    }

    @Test
    void setEmailError() {
        state.setEmailError(null);
    }

    @Test
    void getPassword() {
        assertEquals("", state.getPassword());
    }

    @Test
    void setPassword() {
        state.setPassword("1234");
    }

    @Test
    void getPasswordError() {
        assertNull(state.getPasswordError());
    }

    @Test
    void getRepeatPassword() {
        assertEquals("", state.getRepeatPassword());
    }

    @Test
    void setRepeatPassword() {
        state.setRepeatPassword("null");
    }

    @Test
    void getRepeatPasswordError() {
        assertNull(state.getRepeatPasswordError());
    }

    @Test
    void getSignupError() {
        assertNull(state.getSignupError());
    }

    @Test
    void setSignupError() {
        state.setSignupError("");
        assertEquals("", state.getSignupError());
    }
}