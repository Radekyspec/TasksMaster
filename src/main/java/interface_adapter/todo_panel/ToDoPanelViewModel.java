package interface_adapter.todo_panel;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ToDoPanelViewModel extends ViewModel {
    public static final String TODO_PANEL_TITLE_LABEL = "A ToDo Panel";
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
        propertyChangeSupport.firePropertyChange("new todo panel", null, toDoPanelState);
        // TODO 问题：接收什么名字，做什么改变，才能让不同的需求对接不同的state传送？
        //  自查：Controller - InputData - usecase.Interactor - outputdata - ViewModel implemented by OutputBoundary
    }

    public void firePropertyChanged(String propertyName) {
        propertyChangeSupport.firePropertyChange("import todo panel", null, toDoPanelState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
