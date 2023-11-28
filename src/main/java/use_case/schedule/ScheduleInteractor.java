package use_case.schedule;

import data_access.schedule.ScheduleDataAccessInterface;
import entities.event.Event;

import java.util.List;

public class ScheduleInteractor implements ScheduleInputBoundary {
    private final ScheduleDataAccessInterface scheduleDataAccessInterface;
    private final ScheduleOutputBoundary schedulePresenter;

    public ScheduleInteractor(ScheduleDataAccessInterface scheduleDataAccessInterface, ScheduleOutputBoundary schedulePresenter) {
        this.scheduleDataAccessInterface = scheduleDataAccessInterface;
        this.schedulePresenter = schedulePresenter;
    }

    @Override
    public void getEvent(ScheduleInputData scheduleInputData) {
        int scheduleId = scheduleInputData.scheduleId();
        int projectId = scheduleInputData.projectId();
        List<Event> events = scheduleDataAccessInterface.getEvents(projectId, scheduleId);
        ScheduleOutputData scheduleOutputData = new ScheduleOutputData(events);
        schedulePresenter.prepareGetEventSuccessView(scheduleOutputData);
    }
}
