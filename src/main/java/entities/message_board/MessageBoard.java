package entities.message_board;

import entities.message.Message;

import java.util.Map;

public interface MessageBoard {
    /**
     * Return the ID of the MessageBoard
     *
     * @return its ID
     */
    int getID();

    /**
     * Return all the message in the MessageBoard
     *
     * @return its messages
     */
    Map<Integer, Message> getMessage();

    /**
     * add the new message into our MessageBoard
     *
     * @param message a new message object
     */
    void setMessage(Message message);
}
