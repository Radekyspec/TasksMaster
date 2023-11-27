package entities.comment;

import entities.user.User;

public interface Comment {
    /**
     * Return the ID of the comment
     *
     * @return its ID
     */
    int getId();

    /**
     * Return the Author of the comment
     *
     * @return its author
     */
    User getAuthor();

    /**
     * Return the content of the comment
     *
     * @return its content
     */
    String getContent();
}
