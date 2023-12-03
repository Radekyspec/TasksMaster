package entities.schedule;

import entities.event.Event;

import java.util.List;

public interface Schedule {
    /**
     * return the ID of the schedule
     *
     * @return the ID of the schedule
     */
    long getId();

    /**
     * return the events of the schedule
     *
     * @return the events of the schedule
     */
    List<Event> getEvents();

    /**
     * add a new event to the schedule
     *
     * @param event the new event.
     */
    void addEvent(Event event);
}
