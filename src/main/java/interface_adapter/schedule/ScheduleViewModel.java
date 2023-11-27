package interface_adapter.schedule;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ScheduleViewModel extends ViewModel {
    public static final String SCHEDULE_TITLE_LABEL = "Project Schedule";
    public static final String SCHEDULE_BACK_LABEL = "Back";
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ScheduleViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {
        //todo
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
