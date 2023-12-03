package entities.event;

import entities.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommonEvent implements Event {

    private final long ID;
    private final String name;
    private final String notes;
    private final LocalDateTime startsAt;
    private final LocalDateTime endsAt;
    private final boolean isAllDay;
    private final List<User> userList;

    /**
     * build up an event object.
     *
     * @param id       the id of event
     * @param name     the name of event
     * @param notes    the notes of event
     * @param startsAt starting time of event
     * @param endsAt   ending time of event
     * @param isAllDay whether the event is all day
     */
    public CommonEvent(long id, String name, String notes, LocalDateTime startsAt, LocalDateTime endsAt,
                       boolean isAllDay) {
        ID = id;
        this.name = name;
        this.notes = notes;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.isAllDay = isAllDay;
        userList = new ArrayList<>();
    }

    /**
     * Return the ID of the Event
     *
     * @return its ID
     */
    @Override
    public long getID() {
        return ID;
    }

    /**
     * Return the name of the Event
     *
     * @return its name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Return the Notes of the Event
     *
     * @return its Notes
     */
    @Override
    public String getNotes() {
        return notes;
    }

    /**
     * Return the start time of the Event
     *
     * @return its start time
     */
    @Override
    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    /**
     * Return the end time of the Event
     *
     * @return its end time
     */
    @Override
    public LocalDateTime getEndAt() {
        return endsAt;
    }

    /**
     * Return whether the event is All-day
     *
     * @return whether the event is All-day
     */
    @Override
    public boolean getIsAllDay() {
        return isAllDay;
    }

    /**
     * Return who will join the event
     *
     * @return who will join the event
     */
    @Override
    public List<User> getUserLists() {
        return userList;
    }

    /**
     * join the Event
     */
    @Override
    public void joinEvent(User user) {
        userList.add(user);
    }
}
