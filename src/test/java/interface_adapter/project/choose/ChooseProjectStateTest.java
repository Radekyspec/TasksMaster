package interface_adapter.project.choose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class ChooseProjectStateTest {
    private ChooseProjectState state;

    @BeforeEach
    void setUp() {
        state = new ChooseProjectState();
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
    void getUser() {
        assertNull(state.getUser());
    }

    @Test
    void getChooseProjectError() {
        assertNull(state.getChooseProjectError());
    }
}