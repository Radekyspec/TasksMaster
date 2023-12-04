package entities.project;

import entities.message_board.CommonMessageBoardFactory;
import entities.message_board.MessageBoard;
import entities.schedule.CommonScheduleFactory;
import entities.schedule.Schedule;
import entities.todo_panel.CommonToDoPanelFactory;
import entities.todo_panel.ToDoPanel;
import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CommonProjectTest {
    private User user1;
    private User user2;
    private Project project;
    private ToDoPanel toDoPanel;
    private MessageBoard messageBoard;
    private Schedule schedule;

    @BeforeEach
    void setUp() {
        project = CommonProjectFactory.create(1, "Task Master", "Project for CSC207");
        user1 = CommonUserFactory.create(1, "Sawyer", "Abc123", LocalDateTime.now(), "sawyer030908@gmail.com");
        user2 = CommonUserFactory.create(2, "Kenneth", "Abc123", LocalDateTime.now(), "yukai.liang@mail.utoronto.ca");
        toDoPanel = CommonToDoPanelFactory.create(1);
        messageBoard = CommonMessageBoardFactory.create(1);
        schedule = CommonScheduleFactory.create(1);
    }

    @Test
    void setGetLeader() {
        assertNull(project.getLeader());
        project.setLeader(user1.getName());
        assertEquals("Sawyer", project.getLeader());
    }

    @Test
    void getID() {
        assertEquals(1,project.getID());
    }

    @Test
    void getDescription() {
        assertEquals("Project for CSC207", project.getDescription());
    }

    @Test
    void getName() {
        assertEquals("Task Master", project.getName());
    }

    @Test
    void getSetToDoPanel() {
        assertNull(project.getToDoPanel());
        project.setToDoPanel(toDoPanel);
        assertEquals(toDoPanel, project.getToDoPanel());
    }

    @Test
    void getSetMessageBoard() {
        assertNull(project.getMessageBoard());
        project.setMessageBoard(messageBoard);
        assertEquals(messageBoard, project.getMessageBoard());
    }

    @Test
    void getSetSchedule() {
        assertNull(project.getSchedule());
        project.setSchedule(schedule);
        assertEquals(schedule, project.getSchedule());
    }

    @Test
    void addSetNewMember() {
        assertEquals(0, project.getMembers().size());
        project.addNewMember(user1.getName());
        project.addNewMember(user2.getName());
        assertEquals(2, project.getMembers().size());
    }
}