package data_access.schedule;

import entities.schedule.Schedule;
import java.util.List;

public interface ScheduleDataAccessInterface {
    List<Schedule> getEvents(int id, int projectId);
}
