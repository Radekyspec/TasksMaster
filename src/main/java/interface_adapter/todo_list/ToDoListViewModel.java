package interface_adapter.todo_list;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoListViewModel extends ViewModel {
    public static final String BACK_TO_HOME_BUTTON_LABEL = "HomePage";
    public static final String ADD_NEW_TODO_BUTTON_LABEL = "Add a new ToDo";
    public static final String GO_BACK_BUTTON_LABEL = "Back";
    public static final String IMPORT_TODO_LIST = "import todo list";
    public static final String IMPORT_TODO = "import todo";
    public static final String IMPORT_SINGLE_TODO = "import single todo";
    public static final String IMPORT_TODO_LIST_FAILED = "import error";
    public static final String TITLE_LABEL = "ToDo List";
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final ToDoListState state = new ToDoListState();
    
    public ToDoListViewModel() {
        super("todo list");
    }
    
    public ToDoListState getState() {
        return state;
    }

    /**
     * notice: whether it is "import" or "create", the property name is always todo_list.
     */
    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("todo list", null, state);
    }

    public void firePropertyChanged(String propertyName) {
        propertyChangeSupport.firePropertyChange(propertyName, null, state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
