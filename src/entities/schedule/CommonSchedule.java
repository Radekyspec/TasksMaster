package entities.schedule;

import entities.event.Event;

import java.util.ArrayList;
import java.util.List;

public class CommonSchedule implements Schedule {
    private final int ID;
    private final List<Event> events;

    /**
     * build up a new schedule
     * @param id the id of the schedule
     */
    public CommonSchedule(int id) {
        ID = id;
        this.events = new ArrayList<>();
    }
    /**
     * return the ID of the schedule
     * @return the ID of the schedule
     */
    public int getId() {
        return ID;
    }
    /**
     * return the events of the schedule
     * @return the events of the schedule
     */
    @Override
    public List<Event> getEvents() {
        return events;
    }
    /**
     * add a new event to the schedule
     * @param event the new event.
     */
    @Override
    public void addEvent(Event event) {
        events.add(event);
    }
}
