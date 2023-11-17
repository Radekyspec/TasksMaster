package entities.message;

import entities.comment.Comment;
import entities.user.User;

import java.util.HashMap;
import java.util.Map;

public class CommonMessage implements Message {
    private final int ID;
    private final User author;
    private final String content;
    private final Map<Integer, Comment> comments;

    public CommonMessage(int ID, User author, String content) {
        this.ID = ID;
        this.author = author;
        this.content = content;
        comments = new HashMap<>();
    }

    /**
     *
     * @return
     */
    @Override
    public int getId() {
        return ID;
    }

    @Override
    public User getAuthor() {
        return author;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public Map<Integer, Comment> getComments() {
        return comments;
    }

    @Override
    public void addComment(Comment comment) {
        comments.put(comment.getId(), comment);
    }
}
