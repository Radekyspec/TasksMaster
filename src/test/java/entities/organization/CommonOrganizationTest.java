package entities.organization;

import entities.project.CommonProjectFactory;
import entities.project.Project;
import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CommonOrganizationTest {
    private User user;
    private Project project;
    private Organization organization;

    @BeforeEach
    void setUp() {
        user = CommonUserFactory.create(1, "Sawyer", "Abc123", LocalDateTime.now(), "sawyer030908@gmail.com");
        project = CommonProjectFactory.create(1, "Task Master", "Project for CSC207");
        organization = CommonOrganizationFactory.create(1,"CSC207", user);
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
        assertEquals(user, organization.getOwner());
    }

    @Test
    void getProject_set() {

    }

    @Test
    void getMembers() {
    }

    @Test
    void addMember() {
    }
}