package entities.comment;

import entities.user.User;

public interface Comment {
    int getId();

    User getAuthor();

    String getContent();
}
