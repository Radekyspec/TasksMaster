package entities.event;

import entities.user.User;

import java.time.LocalDateTime;
import java.util.List;

public interface Event {
    /**
     * Return the ID of the Event
     * @return its ID
     */
    int getID();
    /**
     * Return the name of the Event
     * @return its name
     */
    String getName();
    /**
     * Return the Notes of the Event
     * @return its Notes
     */
    String getNotes();
    /**
     * Return the start time of the Event
     * @return its start time
     */
    LocalDateTime getStartsAt();
    /**
     * Return the end time of the Event
     * @return its end time
     */
    LocalDateTime getEndAt();
    /**
     * Return whether the event is All-day
     * @return whether the event is All-day
     */
    boolean getIsAllDay();
    /**
     * Return who will join the event
     * @return who will join the event
     */
    List<User> getUserLists();

    /**
     * join the Event
     */
    void joinEvent(User user);
}
