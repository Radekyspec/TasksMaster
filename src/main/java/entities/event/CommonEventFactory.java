package entities.event;

import java.time.LocalDateTime;

public class CommonEventFactory {
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
    public static CommonEvent create(long id, String name, String notes, LocalDateTime startsAt, LocalDateTime endsAt,
                                     boolean isAllDay) {
        return new CommonEvent(id, name, notes, startsAt, endsAt, isAllDay);
    }
}
