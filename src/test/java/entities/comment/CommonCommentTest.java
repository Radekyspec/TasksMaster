package entities.comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonCommentTest {
    private Comment comment;

    @BeforeEach
    void setUp() {
        comment = CommonCommentFactory.create(1, "Kenneth", "Really a useful Message!");
    }

    @Test
    void getId() {
        assertEquals(1, comment.getId());
    }

    @Test
    void getAuthor() {
        assertEquals("Kenneth", comment.getAuthor());
    }

    @Test
    void getContent() {
        assertEquals("Really a useful Message!", comment.getContent());
    }
}