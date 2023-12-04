package interface_adapter.message_board.add_new_message;

import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.message_board.add_new_message.AddNewMessageOutputBoundary;
import use_case.message_board.add_new_message.AddNewMessageOutputData;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AddNewMessagePresenterTest {
    private AddNewMessageOutputBoundary presenter;

    @BeforeEach
    void setUp() {
        presenter = new AddNewMessagePresenter(new ViewManagerModel(), new MessageBoardViewModel());
    }

    @Test
    void prepareSuccessView() {
        presenter.prepareSuccessView(new AddNewMessageOutputData(null));
    }

    @Test
    void prepareFailView() {
        Timer t = new Timer(1000, e -> {for (Window window : Window.getWindows()) {
            if (window instanceof JDialog) {
                window.dispose();
            }
        }});
        t.setRepeats(false);
        t.start();
        presenter.prepareFailView();
    }
}