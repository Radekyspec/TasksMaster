package interface_adapter.message_board;

import interface_adapter.ViewModel;
import interface_adapter.message_board.message.MessageState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MessageBoardViewModel extends ViewModel {
    public static final String MESSAGE_BOARD_TITLE_LABEL = "Message Board";
    public static final String ADD_NEW_MESSAGE_LABEL = "Add a new message";
    public static final String SET_USER_PROJECT = "set user project";
    public static final String NO_MESSAGE = "There is no message now";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private final MessageBoardState messageBoardState = new MessageBoardState();

    public MessageBoardViewModel() {
        super("Message Board");
    }

    /**
     *
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("new message", null, messageBoardState);
    }

    public MessageBoardState getMessageBoardState() {
        return messageBoardState;
    }

    public void setProjectID(long projectID) {
        messageBoardState.setProjectID(projectID);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }

    public void firePropertyChanged(String propertyName){
        support.firePropertyChange(propertyName, null, messageBoardState);
    }
}
