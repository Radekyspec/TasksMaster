package data_access.schedule;

import entities.event.Event;
import entities.schedule.Schedule;
import java.util.List;

public interface ScheduleDataAccessInterface {
    //List<Schedule> getSchedule(int id, int projectId);
    List<Event> getEvents(int projectId, int id);
}
