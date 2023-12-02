package interface_adapter.project;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainProjectViewModel extends ViewModel {
    public static final String SET_PROJECT_USER = "set project user";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final MainProjectState state = new MainProjectState();


    public MainProjectViewModel() {
        super("main project");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    public void firePropertyChanged(String propertyName){
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
