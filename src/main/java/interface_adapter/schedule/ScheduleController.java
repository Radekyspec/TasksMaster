package interface_adapter.schedule;

import use_case.schedule.ScheduleInputBoundary;
import  use_case.schedule.ScheduleInputData;

public class ScheduleController {
    final ScheduleInputBoundary scheduleInteractor;

    public ScheduleController(ScheduleInputBoundary scheduleInteractor) {
        this.scheduleInteractor = scheduleInteractor;
    }
}
