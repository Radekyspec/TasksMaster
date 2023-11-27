package entities.message_board;

import entities.message.Message;

import java.util.HashMap;
import java.util.Map;

public class CommonMessageBoard implements MessageBoard {
    int ID;
    Map<Integer, Message> messages;

    /**
     * Build a new MessageBoard which containing many massage
     *
     * @param ID the ID of the messageBoard
     */
    public CommonMessageBoard(int ID) {
        this.ID = ID;
        messages = new HashMap<>();
    }

    /**
     * Return the ID of the MessageBoard
     *
     * @return its ID
     */
    @Override
    public int getID() {
        return ID;
    }

    /**
     * Return all the message in the MessageBoard
     *
     * @return its messages
     */
    @Override
    public Map<Integer, Message> getMessage() {
        return messages;
    }

    /**
     * add the new message into our MessageBoard
     *
     * @param message a new message object
     */
    @Override
    public void setMessage(Message message) {
        messages.put(message.getID(), message);
    }
}
