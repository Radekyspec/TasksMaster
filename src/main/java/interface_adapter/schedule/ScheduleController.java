package interface_adapter.schedule;

import use_case.schedule.ScheduleInputBoundary;
import  use_case.schedule.ScheduleInputData;

public class ScheduleController {
    final ScheduleInputBoundary scheduleInteractor;

    public ScheduleController(ScheduleInputBoundary scheduleInteractor) {
        this.scheduleInteractor = scheduleInteractor;
    }

    public void getEvent(int projectId, int eventId) {
        ScheduleInputData scheduleInputData = new ScheduleInputData(projectId, eventId);
        scheduleInteractor.getEvent(scheduleInputData);
    }
}