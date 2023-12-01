package data_access.schedule;

import entities.event.Event;
import java.util.List;

public interface ScheduleDataAccessInterface {
    List<Event> getEvents(int projectId, int id);
}
