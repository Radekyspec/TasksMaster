package interface_adapter.project.choose;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChooseProjectViewModel extends ViewModel {
    public static final String CHOOSE_PROJECT_LABEL = "Choose a project";
    public static final String BUTTON_ENTER_PROJECT_LABEL = "Enter";
    public static final String BUTTON_CREATE_PROJECT_LABEL = "Create a Project";
    public static final String UPDATE_PROJECT = "update project";
    public static final String SET_USER = "set user";
    private final ChooseProjectState state = new ChooseProjectState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ChooseProjectViewModel() {
        super("choose project");
    }

    public ChooseProjectState getState() {
        return state;
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
}
