package interface_adapter.schedule;

import interface_adapter.ViewModel;
import interface_adapter.schedule.ScheduleState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ScheduleViewModel extends ViewModel {
    public static final String SCHEDULE_TITLE_LABEL = "Project Schedule";
    public static final String SCHEDULE_BACK_LABEL = "Back";
    public static final String SCHEDULE_ADD_NEW_EVENT = "Add new event";

    private final ScheduleState scheduleState = new ScheduleState();

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ScheduleViewModel() { super("Schedule"); }

    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("new event", null, scheduleState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public ScheduleState getScheduleState() {
        return scheduleState;
    }

    public void setProjectID(int projectID) { scheduleState.setProjectId(projectID);}
}
