package interface_adapter.message_board;

import interface_adapter.ViewModel;
import interface_adapter.message_board.message.MessageState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MessageBoardViewModel extends ViewModel {
    public static final String MESSAGE_BOARD_TITLE_LABEL = "Message Board";
    public static final String ADD_NEW_MESSAGE_LABEL = "Add a new message";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private final MessageBoardState messageBoardState;

    public MessageBoardViewModel(int ProjectID, int messageBoardID) {
        super("Message Board");
        messageBoardState = new MessageBoardState(ProjectID, messageBoardID);
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

    public void setProjectID(int projectID) {
        messageBoardState.setProjectID(projectID);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }

}
