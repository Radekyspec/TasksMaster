package interface_adapter.todo.add_todo;

import interface_adapter.ViewModel;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddToDoViewModel extends ViewModel {
    public static final String CONFIRM_NEW_TODO_BUTTON_LABEL = "Create";
    public static final String GO_BACK_BUTTON_LABEL = "Cancel";
    private PropertyChangeSupport propertyChangeSupport;
    private AddToDoState addToDoState;

    public AddToDoViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("add todo", null, addToDoState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
