package entities.todo_panel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonToDoPanelTest {
    private ToDoPanel toDoPanel;

    @BeforeEach
    void setUp() {
        toDoPanel = CommonToDoPanelFactory.create(1);
    }

    @Test
    void getId() {
        assertEquals(1, toDoPanel.getId());
    }

    @Test
    void getLists() {
        assertEquals(0, toDoPanel.getLists().size());
    }
}