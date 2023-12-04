package interface_adapter.schedule;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ScheduleViewModel extends ViewModel {
    public static final String SCHEDULE_TITLE_LABEL = "Project Schedule";
    public static final String SCHEDULE_ADD_NEW_EVENT = "Add new event";
    public static final String SCHEDULE_SET_EVENT = "Set event";
    public static final String SCHEDULE_NO_EVENT = "There is no event now";

    private final ScheduleState scheduleState = new ScheduleState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ScheduleViewModel() { super("Schedule"); }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("new event", null, scheduleState);
    }
    public void firePropertyChanged(String scheduleSetEvent) {
        support.firePropertyChange(scheduleSetEvent, null, scheduleState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ScheduleState getScheduleState() {
        return scheduleState;
    }

    public void setProjectID(long projectID) { scheduleState.setProjectId(projectID); }
}
