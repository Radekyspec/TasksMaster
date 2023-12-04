package interface_adapter.project.add;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddProjectViewModel extends ViewModel {
    public static final String ADD_PROJECT_TITLE_LABEL = "Add Your Project";
    public static final String ADD_PROJECT_NAME_LABEL = "Project Name";
    public static final String ADD_PROJECT_DESCRIPTION_LABEL = "Project Description";
    public static final String BUTTON_ENTER_LABEL = "Enter";
    public static final String BUTTON_CANCEL_LABEL = "Cancel";
    public static final String SET_USER = "set user";
    public static final String ADD_PROJECT_ERROR = "add project error";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final AddProjectState state = new AddProjectState();

    public AddProjectViewModel() {
        super("add project");
    }

    @Override
    public void firePropertyChanged() {
        firePropertyChanged("state");
    }

    public void firePropertyChanged(String propertyName) {
        support.firePropertyChange(propertyName, null, state);
    }

    public AddProjectState getState() {
        return state;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
