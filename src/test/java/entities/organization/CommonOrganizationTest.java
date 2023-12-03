package entities.organization;

import entities.project.CommonProjectFactory;
import entities.project.Project;
import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CommonOrganizationTest {
    private User user1;
    private User user2;
    private Project project;
    private Organization organization;

    @BeforeEach
    void setUp() {
        user1 = CommonUserFactory.create(1, "Sawyer", "Abc123", LocalDateTime.now(), "sawyer030908@gmail.com");
        user2 = CommonUserFactory.create(2, "Kenneth", "Abc123", LocalDateTime.now(), "yukai.liang@mail.utoronto.ca");
        project = CommonProjectFactory.create(1, "Task Master", "Project for CSC207");
        organization = CommonOrganizationFactory.create(1,"CSC207", user1);
    }

    @Test
    void getID() {
        assertEquals(1, organization.getID());
    }

    @Test
    void getName() {
        assertEquals("CSC207", organization.getName());
    }

    @Test
    void getOwner() {
        assertEquals(user1, organization.getOwner());
    }

    @Test
    void getProject_set() {
        assertEquals(project, organization.getProject_set().get(project.getID()));
    }

    @Test
    void getAddMembers() {
        assertNull(organization.getMembers());
        organization.addMember(user1);
        organization.addMember(user2);
        assertEquals(2, organization.getMembers().size());
        assertEquals(user1, organization.getMembers().get(1L));
        assertEquals(user2, organization.getMembers().get(2L));
    }
}