package entities.schedule;

import entities.event.CommonEventFactory;
import entities.event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonScheduleTest {
    private Schedule schedule;
    private Event event;
    Date start;
    Date ends;

    @BeforeEach
    void setUp() {
        schedule = CommonScheduleFactory.create(1);
        start = new Date();
        ends = new Date();
        event = CommonEventFactory.create(1, "Presentation", "important", start, ends, false);
    }

    @Test
    void getId() {
        assertEquals(1, schedule.getId());
    }

    @Test
    void getAddEvents() {
        assertEquals(0, schedule.getEvents().size());
        schedule.addEvent(event);
        assertEquals(1, schedule.getEvents().size());
        assertEquals(event, schedule.getEvents().get(0));
    }

}