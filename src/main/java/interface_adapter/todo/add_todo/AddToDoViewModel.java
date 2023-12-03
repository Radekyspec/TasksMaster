package interface_adapter.todo.add_todo;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddToDoViewModel extends ViewModel {
    public static final String CONFIRM_NEW_TODO_BUTTON_LABEL = "Create";
    public static final String GO_BACK_BUTTON_LABEL = "Cancel";
    public static final String CREATE_TODO = "create todo";
    public static final String NAME_IPF = "Create a name for your ToDo";
    public static final String ADD_TODO_TITLE_LABEL = "Create a ToDo";
    private PropertyChangeSupport propertyChangeSupport;
    private final AddToDoState addToDoState = new AddToDoState();

    public AddToDoState getState() {
        return addToDoState;
    }

    public AddToDoViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("add todo", null, addToDoState);
    }

    public void firePropertyChanged(String propertyName) {
        propertyChangeSupport.firePropertyChange(propertyName, null, addToDoState);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {}
}
