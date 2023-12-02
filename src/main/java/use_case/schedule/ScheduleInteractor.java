package use_case.schedule;

import data_access.schedule.ScheduleDataAccessInterface;
import entities.event.Event;
import entities.user.User;
import interface_adapter.schedule.SchedulePresenter;

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
        int scheduleId = scheduleInputData.scheduleId();
        int projectId = scheduleInputData.projectId();
        List<Event> events = scheduleDataAccessInterface.getEvents(projectId, scheduleId);
        ScheduleOutputData scheduleOutputData = new ScheduleOutputData(events);
        schedulePresenter.prepareGetEventSuccessView(scheduleOutputData);
    }

    public void addEvent(ScheduleInputData scheduleInputData) {
        int projectId = scheduleInputData.projectId();
        int scheduleId = scheduleInputData.scheduleId();
        String eventName = scheduleInputData.eventName();
        String notes = scheduleInputData.notes();
        Date startAt = scheduleInputData.startAt();
        Date endAt = scheduleInputData.endAt();
        boolean isAllDay = scheduleInputData.isAllDay();
        List<User> userWith = scheduleInputData.userWith();
        Event event = scheduleDataAccessInterface.addEvents(projectId,scheduleId,eventName,notes,startAt,endAt,isAllDay,userWith);
        List<Event> events = new ArrayList<>();
        events.add(event);
        ScheduleOutputData scheduleOutputData = new ScheduleOutputData(events);
        schedulePresenter.prepareGetEventSuccessView(scheduleOutputData);
    }
}
