package interface_adapter.message_board.add_new_message;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddNewMessageViewModel extends ViewModel {
    public static final String TITLE = "Add a new Message!";
    public static final String TYPE_TITLE_MESSAGE = "Type a title...";
    public static final String TYPE_CONTENT = "Write away...";
    public static final String POST_THIS = "Post this Message";
    private final AddNewMessageState addNewMessageState = new AddNewMessageState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public AddNewMessageViewModel() {
        super("Add a new message");
    }
    public void setProjcetID(int projectID){
        addNewMessageState.setProjectID(projectID);
    }

    public void setMessageBoardID(int messageBoardID){
        addNewMessageState.setMessageBoardID(messageBoardID);
    }

    public AddNewMessageState getAddNewMessageState(){
        return addNewMessageState;
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
