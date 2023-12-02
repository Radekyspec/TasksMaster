package interface_adapter.todo_panel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoPanelViewModel extends ViewModel {
    public static final String TODO_PANEL_TITLE_LABEL = "A ToDo Panel";
    public static final String ADD_NEW_LIST_BUTTON_LABEL = "+ new ToDoList";
    public static final String BACK_TO_HOME_BUTTON_LABEL = "HomePage";
    public static final String CHOOSE_PROJECT_LABEL = "Click one list to start.";
    public static final String SELECT_BUTTON_LABEL = "Select";
    public static final String ADD_NEW_TODOLIST = "add new todo list";
    public static final String IMPORT_TODOLIST = "import todo list";
    public static final String INITIALIZE_TODO_PANEL = "initialize todo panel";
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
