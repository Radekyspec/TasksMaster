package interface_adapter.message_board.add_new_message;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class AddNewMessageViewModel extends ViewModel {
    public AddNewMessageViewModel() {
        super("Add a new message");
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
