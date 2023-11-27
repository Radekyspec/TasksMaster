package use_case.schedule;

import data_access.schedule.ScheduleDataAccessInterface;
import entities.event.Event;
import entities.schedule.Schedule;
import main.java.data_access.message_board.MessageBoardUserDataAccessInterface;

import java.util.List;

public class ScheduleInteractor implements ScheduleInputBoundary {
    private final ScheduleDataAccessInterface scheduleDataAccessInterface;
    private final ScheduleOutputBoundary schedulePresenter;

    public ScheduleInteractor(ScheduleDataAccessInterface scheduleDataAccessInterface, ScheduleOutputBoundary schedulePresenter) {
        this.scheduleDataAccessInterface = scheduleDataAccessInterface;
        this.schedulePresenter = schedulePresenter;
    }

    @Override
    public void getSchedule(ScheduleInputData scheduleInputData) {
        int id = scheduleInputData.id();
        int projectId = scheduleInputData.projectId();
        List<Schedule> schedules = scheduleDataAccessInterface.getEvents(id, projectId);
        ScheduleOutputData scheduleOutputData = new ScheduleOutputData(schedules);
        schedulePresenter.prepareSuccessView(scheduleOutputData);
    }
}
