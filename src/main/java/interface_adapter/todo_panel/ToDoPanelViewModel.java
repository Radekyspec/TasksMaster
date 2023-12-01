package interface_adapter.todo_panel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoPanelViewModel extends ViewModel {
    public static final String TODO_PANEL_TITLE_LABEL = "A ToDo Panel";
    public static final String ADD_NEW_LIST_BUTTON_LABEL = "+ new ToDoList";
    public static final String BACK_TO_HOME_BUTTON_LABEL = "HomePage";
    private final ToDoPanelState toDoPanelState = new ToDoPanelState();
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ToDoPanelViewModel() {
        super("todo panel");
    }

    public ToDoPanelState getToDoPanelState() {
        return toDoPanelState;
    }
    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("todo panel", null, toDoPanelState);
    }

    public void firePropertyChanged(String propertyName) {
        propertyChangeSupport.firePropertyChange(propertyName, null, toDoPanelState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
