package entities.schedule;

import entities.event.Event;

import java.util.List;

public interface Schedule {
    int getId();

    List<Event> getEvents();

    void addEvent(Event event);
}
