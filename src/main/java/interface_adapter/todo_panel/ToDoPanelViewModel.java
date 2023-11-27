package interface_adapter.todo_panel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoPanelViewModel extends ViewModel {
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
        propertyChangeSupport.firePropertyChange("new panel", null, toDoPanelState);
    }

    public void firePropertyChanged(String propertyName) {
        propertyChangeSupport.firePropertyChange("import panel", null, toDoPanelState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
