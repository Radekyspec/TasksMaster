package interface_adapter.todo;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoViewModel extends ViewModel {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final ToDoState toDoState = new ToDoState();

    public ToDoViewModel() {
        super("todo");
    }

    public ToDoState getToDoState() {
        return toDoState;
    }
    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("new todo", null, toDoState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
