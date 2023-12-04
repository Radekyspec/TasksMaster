package entities.message;

import entities.comment.Comment;
import entities.comment.CommonComment;
import entities.comment.CommonCommentFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonMessageTest {
    private Message message;
    private Comment comment;

    @BeforeEach
    void setUp() {
        message = CommonMessageFactory.create(1, "Sawyer", "Project", "Project due day is December 4th!");
        comment = CommonCommentFactory.create(1, "Kenneth", "Really a useful Message!");
    }

    @Test
    void getID() {
        assertEquals(1, message.getID());
    }

    @Test
    void getAuthor() {
        assertEquals("Sawyer", message.getAuthor());
    }

    @Test
    void getTitle() {
        assertEquals("Project", message.getTitle());
    }

    @Test
    void getContent() {
        assertEquals("Project due day is December 4th!", message.getContent());
    }

    @Test
    void getAddComments() {
        assertEquals(0, message.getComments().size());
        message.addComment(comment);
        assertEquals(1, message.getComments().size());
        assertEquals(comment, message.getComments().get(1L));
    }
}