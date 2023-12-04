package interface_adapter.project;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainProjectViewModel extends ViewModel {
    public static final String SET_PROJECT = "set project";
    public static final String SET_USER = "set user";
    public static final String ADD_NEW_PEOPLE = "Add new people";
    public static final String MESSAGE_BOARD = "Message Board";
    public static final String TO_DO_PANEL = "To Do Panel";
    public static final String SCHEDULE = "Schedule";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final MainProjectState state = new MainProjectState();


    public MainProjectViewModel() {
        super("main project");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    public void firePropertyChanged(String propertyName) {
        support.firePropertyChange(propertyName, null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public MainProjectState getState() {
        return state;
    }
}
