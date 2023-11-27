package interface_adapter.project;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainProjectViewModel extends ViewModel {
    private static final String CHOOSE_PROJECT_LABEL = "Choose a project";
    public static final String BUTTON_ENTER_PROJECT_LABEL = "Enter";

    private final MainProjectState state = new MainProjectState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public MainProjectViewModel() {
        super("main project");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
