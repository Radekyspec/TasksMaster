package interface_adapter.todo_list;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoListViewModel extends ViewModel {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final ToDoListState toDoListState = new ToDoListState();
    
    public ToDoListViewModel() {
        super("todo list");
    }
    
    public ToDoListState getToDoListState() {
        return toDoListState;
    }
    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("new todo list", null, toDoListState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
