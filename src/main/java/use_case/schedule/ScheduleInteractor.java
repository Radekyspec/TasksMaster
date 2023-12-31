package use_case.schedule;

import data_access.schedule.ScheduleDataAccessInterface;
import entities.event.Event;

import java.util.ArrayList;
import java.util.Date;
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
        long scheduleId = scheduleInputData.scheduleId();
        long projectId = scheduleInputData.projectId();
        List<Event> events = scheduleDataAccessInterface.getEvents(projectId, scheduleId);
        if (events == null) {
            schedulePresenter.prepareGetEventFailView();
        } else if (events.isEmpty()) {
            schedulePresenter.prepareGetEventFailView();
        } else {
            ScheduleOutputData scheduleOutputData = new ScheduleOutputData(events);
            schedulePresenter.prepareGetEventSuccessView(scheduleOutputData);
        }
    }

    public void addEvent(ScheduleInputData scheduleInputData) {
        long projectId = scheduleInputData.projectId();
        long scheduleId = scheduleInputData.scheduleId();
        String eventName = scheduleInputData.eventName();
        String notes = scheduleInputData.notes();
        Date startAt = scheduleInputData.startAt();
        Date endAt = scheduleInputData.endAt();
        boolean isAllDay = scheduleInputData.isAllDay();
        List<String> userWith = scheduleInputData.userWith();
        Event event = scheduleDataAccessInterface.addEvents(projectId, scheduleId, eventName, notes, startAt, endAt, isAllDay, userWith);
        if (event == null) {
            schedulePresenter.prepareGetEventFailView();
        } else {
            List<Event> events = new ArrayList<>();
            events.add(event);
            ScheduleOutputData scheduleOutputData = new ScheduleOutputData(events);
            schedulePresenter.prepareGetEventSuccessView(scheduleOutputData);
        }
    }
}
