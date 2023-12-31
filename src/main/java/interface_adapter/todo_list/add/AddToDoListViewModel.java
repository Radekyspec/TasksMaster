package interface_adapter.todo_list.add;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddToDoListViewModel extends ViewModel {

    public static final String ADD_NEW_TODO_BUTTON_LABEL = "Create";
    public static final String GO_BACK_BUTTON_LABEL = "Cancel";
    public static final String CREATE_TODO_LIST = "create successful";
    public static final String CREATE_TODO_LIST_FAILED = "create error";
    public static final String NAME_IPF = "Create a name for your ToDoList";
    public static final String DETAIL_IPF = "Detail is needed";
    public static final String ADD_TODO_LIST_TITLE_LABEL = "Create a ToDo List";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final AddToDoListState state = new AddToDoListState();

    public AddToDoListViewModel() {
        super("add todo_list");
    }

    public AddToDoListState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    public void firePropertyChanged(String propertyName) {
        support.firePropertyChange(propertyName, null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
