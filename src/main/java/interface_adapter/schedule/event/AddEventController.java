package interface_adapter.schedule.event;

import entities.event.Event;
import entities.user.User;
import use_case.schedule.add_new_event.AddNewEventInputBoundary;
import use_case.schedule.add_new_event.AddNewEventInputData;

import java.util.Date;
import java.util.List;

public class AddEventController {
    final AddNewEventInputBoundary addNewEventInteractor;

    public AddEventController(AddNewEventInputBoundary addNewEventInteractor) {
        this.addNewEventInteractor = addNewEventInteractor;
    }

    public void postEvent(long projectId, long scheduleId, String eventName, String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userwith) {
        AddNewEventInputData addNewEventInputData = new AddNewEventInputData(projectId,scheduleId,eventName,notes,startAt,endAt,isAllDay,userwith);
        addNewEventInteractor.postEvent(addNewEventInputData);
    }
}
