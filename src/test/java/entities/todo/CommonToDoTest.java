package entities.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonToDoTest {
    private ToDo toDo;
    private ToDo toDo2;
    private ToDo toDo3;
    private String[] strings;
    @BeforeEach
    void setUp() {
        strings = new String[]{};
        toDo = CommonToDoFactory.create(1, "Implement To do View", strings, "incomplete");
        toDo2 = CommonToDoFactory.create(1, "Implement To do View", strings, "complete");
        toDo3 = CommonToDoFactory.create(1, "Implement To do View", strings, "int");
    }

    @Test
    void getTarget() {
        assertEquals("Implement To do View", toDo.getTarget());
    }

    @Test
    void getID() {
        assertEquals(1, toDo.getID());
    }

    @Test
    void getAssignedTo() {
        assertEquals(strings, toDo.getAssignedTo());
    }

    @Test
    void getProgress() {
        assertEquals("incomplete", toDo.getProgress());
    }

    @Test
    void getCharProgress() {
        assertEquals("[ ]", toDo.getCharProgress());
        assertEquals("[x]", toDo2.getCharProgress());
        assertNull(toDo3.getCharProgress());
    }
}