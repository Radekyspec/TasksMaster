package use_case.schedule;

public interface ScheduleOutputBoundary {
    void prepareGetEventSuccessView(ScheduleOutputData scheduleOutputData);

    void prepareGetEventFailView();
}
