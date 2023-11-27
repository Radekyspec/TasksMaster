package use_case.message_board.message;

import entities.comment.Comment;

import java.util.List;

public class MessageOutputData {
    final List<Comment> comments;

    public MessageOutputData(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
