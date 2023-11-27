package entities.schedule;

import entities.event.Event;

import java.util.ArrayList;
import java.util.List;

public class CommonSchedule implements Schedule {
    private final int ID;
    private final List<Event> events;

    public CommonSchedule(int id) {
        ID = id;
        this.events = new ArrayList<>();
    }

    public int getId() {
        return ID;
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }

    @Override
    public void addEvent(Event event) {
        events.add(event);
    }
}
