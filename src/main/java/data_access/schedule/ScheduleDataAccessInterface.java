package data_access.schedule;

import entities.event.Event;
import entities.user.User;

import java.util.Date;
import java.util.List;

public interface ScheduleDataAccessInterface {
    List<Event> getEvents(long projectId, long id);
    Event addEvents(long projectId, long scheduleId, String eventName, String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userWith);
}
