package entities.message;

import entities.comment.Comment;
import entities.user.User;

import java.util.Map;

public interface Message {
    /**
     * Return the ID of the Message
     *
     * @return its ID
     */
    int getID();

    /**
     * Return the Author of the message
     *
     * @return its Author
     */
    User getAuthor();

    /**
     * Return the Tittle of the message
     *
     * @return its tittle
     */
    String getTitle();

    /**
     * Return the content of the message
     *
     * @return its content
     */
    String getContent();

    /**
     * Return the comments of the message
     *
     * @return its comments
     */
    Map<Integer, Comment> getComments();

    /**
     * add new comment to the message
     *
     * @param comment a comments object.
     */
    void addComment(Comment comment);
}
