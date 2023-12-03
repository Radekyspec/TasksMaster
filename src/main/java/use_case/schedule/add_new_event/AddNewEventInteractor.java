package use_case.schedule.add_new_event;

import data_access.schedule.ScheduleDataAccessInterface;
import entities.event.Event;
import entities.user.User;
import use_case.message_board.add_new_message.AddNewMessageInteractor;
import use_case.message_board.add_new_message.AddNewMessageOutputData;

import java.util.Date;
import java.util.List;

public class AddNewEventInteractor implements AddNewEventInputBoundary {
    final ScheduleDataAccessInterface scheduleDataAccessInterface;
    final AddNewEventOutputBoundary addNewEventPrensenter;

    public AddNewEventInteractor(ScheduleDataAccessInterface scheduleDataAccessInterface, AddNewEventOutputBoundary addNewEventPrensenter) {
        this.scheduleDataAccessInterface = scheduleDataAccessInterface;
        this.addNewEventPrensenter = addNewEventPrensenter;
    }

    @Override
    public void postEvent(AddNewEventInputData addNewEventInputData) {
        long projectId = addNewEventInputData.getProjectId();
        long scheduleId = addNewEventInputData.getScheduleId();
        String eventName = addNewEventInputData.getEventname();
        String notes = addNewEventInputData.getNotes();
        Date startAt = addNewEventInputData.getStartAt();
        Date endAt = addNewEventInputData.getEndAt();
        boolean isAllDay = addNewEventInputData.getIsAllDay();
        List<String> userWith = addNewEventInputData.getUserWith();

        Event event = scheduleDataAccessInterface.addEvents(projectId, scheduleId, eventName, notes, startAt, endAt, isAllDay, userWith);
        AddNewEventOutputData addNewEventOutputData = new AddNewEventOutputData(event);
        addNewEventPrensenter.prepareSuccessView(addNewEventOutputData);
    }
}
