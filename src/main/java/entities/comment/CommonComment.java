package entities.comment;

import entities.user.User;

public class CommonComment implements Comment {
    private final int ID;
    private final User author;
    private final String content;

    public CommonComment(int id, User author, String content) {
        ID = id;
        this.author = author;
        this.content = content;
    }


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
}
