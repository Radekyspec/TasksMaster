package data_access;

import entities.project.CommonProjectFactory;
import entities.project.Project;
import entities.user.CommonUserFactory;
import exceptions.InvalidApiKeyException;
import exceptions.InvalidUserConfigException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.EOFException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class HttpDataAccessObjectTest {
    private HttpDataAccessObject dataAccessObject;
    @BeforeEach
    void setUp() {
        try {
            dataAccessObject = new InMemoryUserDataAccessObject("BAhbB0kiAbB7ImNsaWVudF9pZCI6ImU1Mzc4MTlhMDA3YzQ4ODU4MWM3ZjI2OGIyYTc0ZmEzNDU5NzU4M2QiLCJleHBpcmVzX2F0IjoiMjAyMy0xMi0xMVQwMzo1OTowNVoiLCJ1c2VyX2lkcyI6WzQ4NjQyMDUxXSwidmVyc2lvbiI6MSwiYXBpX2RlYWRib2x0IjoiZTVkNTFmNjM0Y2ZmYjA0ZmE1M2FmOWEzYjg0Mjg0NjkifQY6BkVUSXU6CVRpbWUNY+0ewLmxVewJOg1uYW5vX251bWkCjQM6DW5hbm9fZGVuaQY6DXN1Ym1pY3JvIgeQkDoJem9uZUkiCFVUQwY7AEY=--fcf956b3050afbd54e783afe6f8df60a3f12127b", "./users.csv");
        } catch (Exception e) {
            fail("Initialize error");
        }

    }

    @Test
    void testInitializeError() {
        assertThrows(InvalidApiKeyException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new InMemoryUserDataAccessObject("", "");
            }
        });

    }

    @Test
    void getApiErrorMessage() {
        assertNull(dataAccessObject.getApiErrorMessage());
    }

    @Test
    void getAllProjects() {
        assertNotNull(dataAccessObject.getAllProjects());
    }

    @Test
    void getUserProjects() {
        assertEquals(0, dataAccessObject.getUserProjects(CommonUserFactory.create(
                0, "DNEDNEDNEDNE", "Aa1", LocalDateTime.now(), "1@a.a")).size());
    }

    @Test
    void createProject() {
        assertNotNull(dataAccessObject.createProject(
                CommonUserFactory.create(
                        0, "TESTTESTCREATE", "Aa1", LocalDateTime.now(), "1@a.a"
                ),
                LocalDateTime.now().toString(),
                "DESCDESC"
        ));
    }

    @Test
    void addProjectMember() {
        Project project = dataAccessObject.createProject(
                CommonUserFactory.create(0, "TESTTESTCREATE", "Aa1", LocalDateTime.now(), "1@a.a"),
                "TESTADDMEMBER", "TESTTEST");
        assertTrue(dataAccessObject.addProjectMember(project, LocalDateTime.now().toString()));
    }

    @Test
    void exists() {
        assertTrue(dataAccessObject.exists("TESTTESTCREATE", CommonProjectFactory.create(35395139L, "TESTADDMEMBER", "TESTTEST")));
    }

    @Test
    void getMessages() {
        assertNotNull(dataAccessObject.getMessages(35395139L, 6813785864L));
    }

    @Test
    void getComments() {
        assertNotNull(dataAccessObject.getComments(35395139L, 6813792275L));
    }

    @Test
    void addComment() {
        assertNotNull(dataAccessObject.addComment(35395139L, 6813792275L, CommonUserFactory.create(0, "TESTTESTCREATE", "Aa1", LocalDateTime.now(), "1@a.a"),
                LocalDateTime.now().toString()));
    }

    @Test
    void addMessage() {
        assertNotNull(dataAccessObject.addMessage(35395139L, 6813785864L, CommonUserFactory.create(0, "TESTTESTCREATE", "Aa1", LocalDateTime.now(), "1@a.a"), "TITLETITLE", LocalDateTime.now().toString()));
    }

    @Test
    void createToDo() {
        assertNotNull(dataAccessObject.createToDo(35395139L, 6813797855L, LocalDateTime.now().toString(), "incomplete"));
    }

    @Test
    void importToDo() {
        assertNotNull(dataAccessObject.importToDo(35395139L, 6813797855L));
    }

    @Test
    void createToDoList() {
        assertNotNull(dataAccessObject.createToDoList(35395139L, 6813785867L, LocalDateTime.now().toString(), "details"));
    }

    @Test
    void importToDoList() {
        assertNotNull(dataAccessObject.importToDoList(35395139L, 6813785867L));
    }

    @Test
    void getEvents() {
        assertNotNull(dataAccessObject.getEvents(35395139L, 6813785880L));
    }

    @Test
    void addEvents() {
        try {
            assertNotNull(dataAccessObject.addEvents(
                    35395139L, 6813785880L, "TESTevent", "nonotes",
                    new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-06T00:00:00.000Z"),
                    new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-06T00:00:00.000Z"), false, new ArrayList<>()
            ));
        } catch (ParseException e) {
            fail("Date parse error");
        }

    }
}