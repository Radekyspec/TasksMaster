package entities.schedule;

import entities.event.Event;

import java.util.List;

public interface Schedule {
    List<Event> getEvents();
    void addEvent(Event event);
}
