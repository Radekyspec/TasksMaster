package interface_adapter.project.add;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class AddProjectViewModel extends ViewModel {

    public AddProjectViewModel() {
        super("add project");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
