package view.message_board;

import entities.message.CommonMessageFactory;
import entities.message.Message;
import entities.message_board.CommonMessageBoardFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardController;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.add_new_message.AddNewMessageViewModel;
import interface_adapter.message_board.message.MessageViewModel;
import interface_adapter.project.MainProjectViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageBoardViewTest {
    private MessageBoardView messageBoardView;
    private MessageBoardViewModel messageBoardViewModel = new MessageBoardViewModel();

    @BeforeEach
    void setUp() {
        messageBoardView = new MessageBoardView(
                new ViewManagerModel(),
                new MainProjectViewModel(),
                messageBoardViewModel,
                new AddNewMessageViewModel(),
                new MessageViewModel(),
                new MessageBoardController(messageBoardInputData -> {})
        );
    }

    @Test
    void actionPerformed() {
        Message message = CommonMessageFactory.create(
                0, "", "", ""
        );
        messageBoardViewModel.getMessageBoardState().setMessageBoard(CommonMessageBoardFactory.create(0));
        messageBoardViewModel.firePropertyChanged(MessageBoardViewModel.SET_USER_PROJECT);
        messageBoardViewModel.getMessageBoardState().setMessage(message);
        messageBoardViewModel.firePropertyChanged(MessageBoardViewModel.ADD_NEW_MESSAGE_LABEL);
        try {
            Field buttonToMessage = MessageBoardView.class.getDeclaredField("buttonToMessage");
            buttonToMessage.setAccessible(true);
            Map<JButton, Message> bT = (HashMap<JButton, Message>) buttonToMessage.get(messageBoardView);
            for (JButton b : bT.keySet()) {
                if (bT.get(b).equals(message)) {
                    messageBoardView.actionPerformed(new ActionEvent(b, 0, ""));
                }
            }

        } catch (IllegalAccessException | NoSuchFieldException e) {
            fail("Attempt failed");
        }


    }

    @Test
    void propertyChange() {
    }

    @Test
    void getViewName() {
    }
}