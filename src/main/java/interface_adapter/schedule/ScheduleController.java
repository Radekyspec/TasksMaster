package interface_adapter.schedule;

import entities.user.User;
import use_case.schedule.ScheduleInputBoundary;
import  use_case.schedule.ScheduleInputData;

import java.util.Date;
import java.util.List;

public class ScheduleController {
    final ScheduleInputBoundary scheduleInteractor;

    public ScheduleController(ScheduleInputBoundary scheduleInteractor) {
        this.scheduleInteractor = scheduleInteractor;
    }

    public void getEvent(long projectId, long eventId, String name, String note, Date startAt, Date endAt, boolean isAllDay, List<String> userWith) {
        ScheduleInputData scheduleInputData = new ScheduleInputData(projectId, eventId, name, note, startAt, endAt, isAllDay, userWith);
        scheduleInteractor.getEvent(scheduleInputData);
    }
}