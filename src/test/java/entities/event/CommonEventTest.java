package entities.event;

import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CommonEventTest {
    private Event event;
    private User user;
    Date start;
    Date ends;

    @BeforeEach
    void setUp() {
        start = new Date();
        ends = new Date();
        event = CommonEventFactory.create(1, "Presentation", "important", start, ends, false);
        user = CommonUserFactory.create(1, "Sawyer", "Abc123", LocalDateTime.now(), "sawyer030908@gmail.com");
    }

    @Test
    void getID() {
        assertEquals(1, event.getID());
    }

    @Test
    void getName() {
        assertEquals("Presentation", event.getName());
    }

    @Test
    void getNotes() {
        assertEquals("important", event.getNotes());
    }

    @Test
    void getStartsAt() {
        assertEquals(start, event.getStartsAt());
    }

    @Test
    void getEndAt() {
        assertEquals(ends, event.getEndAt());
    }

    @Test
    void getIsAllDay() {
        assertFalse(event.getIsAllDay());
    }

    @Test
    void joinEventGetUserList() {
        assertEquals(0, event.getUserLists().size());
        event.joinEvent(user);
        assertEquals(1, event.getUserLists().size());
        assertEquals(user, event.getUserLists().get(0));
    }
}