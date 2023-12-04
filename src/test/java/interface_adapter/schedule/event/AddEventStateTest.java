package interface_adapter.schedule.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddEventStateTest {
    private AddEventState state;

    @BeforeEach
    void setUp() {
        state = new AddEventState();
    }

    @Test
    void setProjectId() {
        state.setProjectId(0);
    }

    @Test
    void setScheduleId() {
        state.setScheduleId(0);
    }

    @Test
    void setEventName() {
        state.setEventName(null);
    }

    @Test
    void setNotes() {
        state.setNotes(null);
    }

    @Test
    void setStartAt() {
        state.setStartAt(null);
    }

    @Test
    void setEndAt() {
        state.setEndAt(null);
    }

    @Test
    void setAllDay() {
        state.setAllDay(true);
    }

    @Test
    void setUserwith() {
        state.setUserwith(null);
    }

    @Test
    void getProjectId() {
        assertEquals(0, state.getProjectId());
    }

    @Test
    void getScheduleId() {
        assertEquals(0, state.getScheduleId());
    }

    @Test
    void getEventName() {
        assertNull(state.getEventName());
    }

    @Test
    void getNotes() {
        assertNull(state.getNotes());
    }

    @Test
    void getStartAt() {
        assertNull(state.getStartAt());
    }

    @Test
    void getEndAt() {
        assertNull(state.getEndAt());
    }

    @Test
    void isAllDay() {
        state.setAllDay(true);
        assertTrue(state.isAllDay());
    }

    @Test
    void getUserwith() {
        assertNull(state.getUserwith());
    }
}