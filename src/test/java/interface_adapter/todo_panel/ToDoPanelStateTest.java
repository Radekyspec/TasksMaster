package interface_adapter.todo_panel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ToDoPanelStateTest {
    private ToDoPanelState state;

    @BeforeEach
    void setUp() {
        state = new ToDoPanelState();
    }

    @Test
    void getUser() {
        assertNull(state.getUser());
    }

    @Test
    void setUser() {
        state.setUser(null);
    }

    @Test
    void getProject() {
        assertNull(state.getProject());
    }

    @Test
    void setProject() {
        state.setProject(null);
    }

    @Test
    void getProjectID() {
        assertEquals(0, state.getProjectID());
    }

    @Test
    void setProjectID() {
        state.setProjectID(0);
    }

    @Test
    void getToDoPanelID() {
        assertEquals(0, state.getToDoPanelID());
    }

    @Test
    void setToDoPanelID() {
        state.setToDoPanelID(0);
    }

    @Test
    void getNewCreatedTDL() {
        assertNull(state.getNewCreatedTDL());
    }

    @Test
    void setNewCreatedTDL() {
        state.setNewCreatedTDL(null);
    }

    @Test
    void getToDoPanelError() {
        state.setToDoPanelError(null);
        assertNull(state.getToDoPanelError());
    }

    @Test
    void setToDoPanelError() {
        state.setToDoPanelError(null);
    }

    @Test
    void getCurrentToDoPanel() {
        assertNull(state.getCurrentToDoPanel());
    }

    @Test
    void setCurrentToDoPanel() {
        state.setCurrentToDoPanel(null);
    }

    @Test
    void getImportToDoListError() {
        state.setImportToDoListError(null);
        assertNull(state.getImportToDoListError());
    }

    @Test
    void setImportToDoListError() {
        state.setImportToDoListError(null);
    }
}