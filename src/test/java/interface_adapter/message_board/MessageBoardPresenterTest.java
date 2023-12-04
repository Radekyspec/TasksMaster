package interface_adapter.message_board;

import entities.message.CommonMessage;
import entities.message.CommonMessageFactory;
import entities.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.message_board.MessageBoardOutputBoundary;
import use_case.message_board.MessageBoardOutputData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageBoardPresenterTest {
    private MessageBoardOutputBoundary presenter;

    @BeforeEach
    void setUp() {
        presenter = new MessageBoardPresenter(new MessageBoardViewModel());
    }

    @Test
    void prepareGetMessagesSuccessView() {
        List<Message> messages = new ArrayList<>();
        messages.add(CommonMessageFactory.create(
                0, "", "", ""
        ));
        presenter.prepareGetMessagesSuccessView(new MessageBoardOutputData(messages));
    }

    @Test
    void prepareGetMessageFailView() {
        Timer t = new Timer(1000, e -> {for (Window window : Window.getWindows()) {
            if (window instanceof JDialog) {
                window.dispose();
            }
        }});
        t.setRepeats(false);
        t.start();
        presenter.prepareGetMessageFailView();
    }
}