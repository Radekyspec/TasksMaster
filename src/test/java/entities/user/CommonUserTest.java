package entities.user;

import entities.organization.CommonOrganizationFactory;
import entities.organization.Organization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CommonUserTest {
    private User user1;
    private User user2;
    private Organization organization;
    private LocalDateTime now = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        user1 = CommonUserFactory.create(1, "Sawyer", "Abc123", now, "sawyer030908@gmail.com");
        user2 = CommonUserFactory.create(2, "Kenneth", "Abc123", LocalDateTime.now(), "yukai.liang@mail.utoronto.ca");
        organization = CommonOrganizationFactory.create(1,"CSC207", user1);
    }

    @Test
    void getID() {
        assertEquals(1, user1.getID());
    }

    @Test
    void getName() {
        assertEquals("Sawyer", user1.getName());
    }

    @Test
    void getPassword() {
        assertEquals("Abc123", user1.getPassword());
    }

    @Test
    void getCreationTime() {
        assertEquals(now, user1.getCreationTime());
    }

    @Test
    void getEmail() {
        assertEquals("sawyer030908@gmail.com", user1.getEmail());
    }

    @Test
    void setGetRule() {
        assertNull(user1.getRule());
        user1.setRule(Rule.BOSS);
        assertEquals(Rule.BOSS, user1.getRule());
    }

    @Test
    void joinGetOrganization() {
        assertNull(user2.getOrganization());
        user2.joinOrganization(organization);
        assertEquals(organization, user2.getOrganization());
    }
}