package interface_adapter.project;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainProjectViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public MainProjectViewModel() {
        super("main project");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
