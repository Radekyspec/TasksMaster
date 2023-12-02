package interface_adapter.project.add_people;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddPeopleViewModel extends ViewModel {
    public static final String ADD_NEW_PEOPLE = "add new people";
    public static final String TYPE_NAME = "type the name here...";
    public static final String ENTER = "Enter";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final AddPeopleState state = new AddPeopleState();

    public AddPeopleViewModel() {
        super("add people");
    }

    public AddPeopleState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {
        firePropertyChanged("state");
    }

    public void firePropertyChanged(String propertyName) {
        support.firePropertyChange(propertyName, null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
