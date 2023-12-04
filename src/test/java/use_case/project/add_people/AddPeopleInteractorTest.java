package use_case.project.add_people;

import data_access.project.ProjectUserDataAccessInterface;
import entities.project.CommonProjectFactory;
import entities.project.Project;
import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddPeopleInteractorTest {
    private AddPeopleOutputBoundary presenter;
    private ProjectUserDataAccessInterface userDAO;
    private AddPeopleInputBoundary interactor;
    private User user;
    private Project project;

    @BeforeEach
    void setUp() {
        user = CommonUserFactory.create(
                0, "Radeky", "Aa1", LocalDateTime.now(), "1@a.a"
        );
        project = CommonProjectFactory.create(
                0, "project", "desc"
        );
        userDAO = new ProjectUserDataAccessInterface() {
            @Override
            public List<Project> getAllProjects() {
                return null;
            }

            @Override
            public boolean addProjectMember(Project project, String username) {
                project.addNewMember(username);
                return true;
            }

            @Override
            public String getApiErrorMessage() {
                return null;
            }

            @Override
            public boolean exists(String username, Project project) {
                return project == null;
            }
        };
        presenter = new AddPeopleOutputBoundary() {
            @Override
            public void prepareFailView() {

            }

            @Override
            public void prepareSuccessView(AddPeopleOutputData addPeopleOutputData) {
                assertTrue(addPeopleOutputData.project().getMembers().contains(user.getName()));
            }
        };
        interactor = new AddPeopleInteractor(presenter, userDAO);
    }

    @Test
    void execute() {
        interactor.execute(new AddPeopleInputData(user.getName(), project));
        interactor.execute(new AddPeopleInputData(user.getName(), null));
    }
}