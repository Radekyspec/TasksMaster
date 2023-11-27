package use_case.schedule;

import entities.schedule.Schedule;

import java.util.List;

public class ScheduleOutputData {
    private final List<Schedule> schedules;

    public ScheduleOutputData(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Schedule> getSchedules() {
        return this.schedules;
    }
}
