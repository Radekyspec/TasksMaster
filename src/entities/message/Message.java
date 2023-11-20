package entities.message;

import entities.comment.Comment;
import entities.user.User;

import java.util.Map;

public interface Message {
    int getId();

    User getAuthor();

    String getContent();

    Map<Integer, Comment> getComments();

    void addComment(Comment comment);
}
