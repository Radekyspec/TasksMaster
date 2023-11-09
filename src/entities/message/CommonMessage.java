package entities.message;

import entities.user.User;
import entities.comment.Comment;
import java.util.HashMap;
import java.util.Map;

public class CommonMessage {
    private final int id;
    private final User author;
    private final String content;
    private final Map<Integer, Comment> comments;

    public CommonMessage(int ID, User author, String content) {
        this.id = ID;
        this.author = author;
        this.content = content;
        comments = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Map<Integer, Comment> getComments() {
        return comments;
    }
}
