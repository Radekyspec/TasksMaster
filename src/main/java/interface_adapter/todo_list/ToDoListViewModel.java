package interface_adapter.todo_list;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoListViewModel extends ViewModel {
    public static final String BACK_TO_HOME_BUTTON_LABEL = "HomePage";
    public static final String ADD_NEW_TODO_BUTTON_LABEL = "Add a new ToDo";
    public static final String GO_BACK_BUTTON_LABEL = "Back";
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final ToDoListState toDoListState = new ToDoListState();
    
    public ToDoListViewModel() {
        super("todo list");
    }
    
    public ToDoListState getToDoListState() {
        return toDoListState;
    }

    /**
     * notice: whether it is "import" or "create", the property name is always todo_list.
     */
    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("todo list", null, toDoListState);
    }

    public void firePropertyChanged(String propertyName) {
        propertyChangeSupport.firePropertyChange(propertyName, null, toDoListState);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
