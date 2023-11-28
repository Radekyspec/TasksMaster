package use_case.schedule;

import entities.event.Event;
import entities.schedule.Schedule;

import java.util.List;

public class ScheduleOutputData {
    private final List<Event> events;

    public ScheduleOutputData(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return this.events;
    }
}
