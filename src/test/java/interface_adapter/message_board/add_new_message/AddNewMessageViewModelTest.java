package interface_adapter.message_board.add_new_message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AddNewMessageViewModelTest {
    private AddNewMessageViewModel addNewMessageViewModel;

    @BeforeEach
    void setUp() {
        addNewMessageViewModel = new AddNewMessageViewModel();
    }

    @Test
    void setProjcetID() {
        addNewMessageViewModel.setProjcetID(0);
    }

    @Test
    void setMessageBoardID() {
        addNewMessageViewModel.setMessageBoardID(0);
    }

    @Test
    void getAddNewMessageState() {
        assertNotNull(addNewMessageViewModel.getAddNewMessageState());
    }

    @Test
    void firePropertyChanged() {
        addNewMessageViewModel.firePropertyChanged();
    }

    @Test
    void addPropertyChangeListener() {
        addNewMessageViewModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        });
    }
}