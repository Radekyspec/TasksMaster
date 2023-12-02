package entities.comment;

import entities.user.User;

public class CommonComment implements Comment {
    private final int ID;
    private final String author;
    private final String content;

    /**
     * build up the new comment with user
     *
     * @param id      the ID of the comment
     * @param author  the author of the comment
     * @param content the content of the comment
     */
    public CommonComment(int id, String author, String content) {
        ID = id;
        this.author = author;
        this.content = content;
    }


    /**
     * Return the ID of the comment
     *
     * @return its ID
     */
    @Override
    public int getId() {
        return ID;
    }

    /**
     * Return the Author of the comment
     *
     * @return its author
     */
    @Override
    public String getAuthor() {
        return author;
    }

    /**
     * Return the content of the comment
     *
     * @return its content
     */
    @Override
    public String getContent() {
        return content;
    }
}
