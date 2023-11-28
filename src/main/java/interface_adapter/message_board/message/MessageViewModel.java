package interface_adapter.message_board.message;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MessageViewModel extends ViewModel {
    private final MessageState state = new MessageState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public MessageViewModel() {
        super("Message View");
    }

    public MessageState getState() {
        return state;
    }

    /**
     *
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("new message", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }
}
