package use_case.schedule;

public interface ScheduleInputBoundary {
    void getEvent(ScheduleInputData scheduleInputData);

    void addEvent(ScheduleInputData scheduleInputData);
}
