package interface_adapter.schedule.event;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.List;

public class AddEventViewModel extends ViewModel{
    public static final String EVENT_NAME = "Event Title";
    public static final String EVENT_NOTES = "Event Notes";
    public static final String EVENT_STARTDATE = "Start at (dd-MM-yyyy)";
    public static final String EVENT_ENDDATE = "End at (dd-MM-yyyy)";
    public static final String EVENT_ISALLDAY = "Is all day? Type 'Y' or 'N'";
    public static final String EVENT_USERWITH = "User with? Separate user by using ',' (No space) ";
    public static final String EVENT_POST = "Post this event";
    public static final String EVENT_POST_FAIL = "Fail to post this event";

    private final AddEventState addEventState = new AddEventState();
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public AddEventViewModel() {
        super("Add a new event");
    }

    public void setProjectId(long projectId) {
        addEventState.setProjectId(projectId);
    }
    public void setScheduleId(long scheduleId) {
        addEventState.setScheduleId(scheduleId);
    }
    public void setEventName(String eventName) {
        addEventState.setEventName(eventName);
    }
    public void setNotes(String notes) {
        addEventState.setNotes(notes);
    }
    public void setStartAt(Date startAt) {
        addEventState.setStartAt(startAt);
    }
    public void setEndAt(Date endAt) {
        addEventState.setEndAt(endAt);
    }
    public void setIsAllDay(boolean isAllDay) {
        addEventState.setAllDay(isAllDay);
    }
    public void setUserWith(List<String> userWith) {
        addEventState.setUserwith(userWith);
    }

    public AddEventState getAddEventState() {
        return addEventState;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
