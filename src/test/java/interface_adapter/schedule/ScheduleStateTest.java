package interface_adapter.schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleStateTest {
    private ScheduleState state;

    @BeforeEach
    void setUp() {
        state = new ScheduleState();
    }

    @Test
    void setEvent() {
        state.setEvent(null);
    }

    @Test
    void setSchedule() {
        state.setSchedule(null);
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
        state.setEventName("");
    }

    @Test
    void setNotes() {
        state.setNotes("");
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
    void getEvent() {
        assertNull(state.getEvent());
    }

    @Test
    void getSchedule() {
        assertNull(state.getSchedule());
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
        assertNull(state.getNotes());
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