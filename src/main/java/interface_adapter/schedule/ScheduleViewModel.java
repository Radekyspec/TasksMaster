package interface_adapter.schedule;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ScheduleViewModel extends ViewModel {
    public static final String SCHEDULE_TITLE_LABEL = "Project Schedule";
    public static final String SCHEDULE_BACK_LABEL = "Back";
    public static final String SCHEDULE_ADD_NEW_EVENT = "Add new event";

    private final ScheduleState scheduleState;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ScheduleViewModel(int projectId, int scheduleId) {
        super("Schedule");
        scheduleState = new ScheduleState(projectId, scheduleId);
    }

    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("new event", null, scheduleState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ScheduleState getScheduleState() {
        return scheduleState;
    }
}
