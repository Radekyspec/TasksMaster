package interface_adapter.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainProjectStateTest {
    private MainProjectState mainProjectState;

    @BeforeEach
    void setUp() {
        mainProjectState = new MainProjectState();
    }

    @Test
    void getProject() {
        assertNull(mainProjectState.getProject());
    }

    @Test
    void setProject() {
        mainProjectState.setProject(null);
    }

    @Test
    void getUser() {
        assertNull(mainProjectState.getUser());
    }

    @Test
    void setUser() {
        mainProjectState.setUser(null);
    }
}