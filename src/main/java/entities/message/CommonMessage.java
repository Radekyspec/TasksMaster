package entities.message;

import entities.comment.Comment;
import entities.user.User;

import java.util.HashMap;
import java.util.Map;

public class CommonMessage implements Message {
    private final long ID;
    private final String author;
    private final String title;
    private final String content;
    private final Map<Long, Comment> comments;

    /**
     * build up the CommonMessage object
     *
     * @param ID      the ID of message
     * @param author  the author of message
     * @param title   the tittle of message
     * @param content the content of message
     */
    public CommonMessage(long ID, String author, String title, String content) {
        this.ID = ID;
        this.author = author;
        this.title = title;
        this.content = content;
        comments = new HashMap<>();
    }


    /**
     * Return the ID of the Message
     *
     * @return its ID
     */
    @Override
    public long getID() {
        return ID;
    }

    /**
     * Return the Author of the message
     *
     * @return its Author
     */
    @Override
    public String getAuthor() {
        return author;
    }

    /**
     * Return the Tittle of the message
     *
     * @return its tittle
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Return the content of the message
     *
     * @return its content
     */
    @Override
    public String getContent() {
        return content;
    }

    /**
     * Return the comments of the message
     *
     * @return its comments
     */
    @Override
    public Map<Long, Comment> getComments() {
        return comments;
    }

    /**
     * add new comment to the message
     *
     * @param comment a comments object.
     */
    @Override
    public void addComment(Comment comment) {
        comments.put(comment.getId(), comment);
    }
}
