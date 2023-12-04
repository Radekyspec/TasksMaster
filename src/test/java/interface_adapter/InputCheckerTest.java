package interface_adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputCheckerTest {

    @Test
    void containsCapital() {
        assertTrue(InputChecker.containsCapital("Aa1"));
        assertFalse(InputChecker.containsCapital("abc3"));
    }

    @Test
    void containsLetter() {
        assertTrue(InputChecker.containsLetter("1a34@"));
        assertFalse(InputChecker.containsLetter("56789"));
    }

    @Test
    void containsNumber() {
        assertTrue(InputChecker.containsNumber("abhd6i"));
        assertFalse(InputChecker.containsNumber("good course"));
    }

    @Test
    void containsNonWord() {
        assertTrue(InputChecker.containsNonWord("123#"));
        assertFalse(InputChecker.containsNonWord("abcdefg"));
    }

    @Test
    void containsWhiteSpace() {
        assertTrue(InputChecker.containsWhiteSpace("abc 123"));
        assertFalse(InputChecker.containsWhiteSpace("makemybookrotate"));
    }

    @Test
    void containsValidEmail() {
        assertTrue(InputChecker.containsValidEmail("me@example.com"));
        assertFalse(InputChecker.containsValidEmail("bababa"));
    }
}