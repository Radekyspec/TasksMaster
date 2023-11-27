package main.java.interface_adapter.message_board.message;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class MessageViewModel extends ViewModel {
    private final MessageState state = new MessageState();
    public MessageViewModel(){
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

    }

    /**
     * @param listener
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
