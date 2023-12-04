package use_case.project.choose;

import data_access.project.choose.ChooseProjectUserDataAccessInterface;
import entities.project.CommonProjectFactory;
import entities.project.Project;
import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChooseProjectInteractorTest {
    private ChooseProjectUserDataAccessInterface userDAO;
    private ChooseProjectOutputBoundary projectPresenter;
    private ChooseProjectInputBoundary interactor;

    @BeforeEach
    void setUp() {
        userDAO = new ChooseProjectUserDataAccessInterface() {
            @Override
            public List<Project> getUserProjects(User user) {
                if (user == null) {
                    return null;
                }
                List<Project> projects = new ArrayList<>();
                projects.add(CommonProjectFactory.create(1, "d123", "213214"));
                return projects;
            }

            @Override
            public String getApiErrorMessage() {
                return "1234";
            }
        };
        projectPresenter = new ChooseProjectOutputBoundary() {
            @Override
            public void prepareChooseSuccessView(ChooseProjectOutputData outputData) {
                assertEquals(1, outputData.getProjectList().size());
                assertFalse(outputData.isUseCaseFailed());
            }

            @Override
            public void prepareChooseFailView(ChooseProjectOutputData outputData) {
                assertEquals("1234", outputData.getError());
            }

            @Override
            public void prepareEnterSuccessView(ChooseProjectOutputData outputData) {
                assertNotNull(outputData.getChosenProject());
            }
        };
        interactor = new ChooseProjectInteractor(projectPresenter, userDAO);
    }

    @Test
    void execute() {
        interactor.execute(new ChooseProjectInputData(CommonProjectFactory.create(1, "", "")));
    }

    @Test
    void getUserProjects() {
        interactor.getUserProjects(new ChooseProjectInputData(CommonUserFactory.create(1, "", "", LocalDateTime.now(), "")));
        User user = null;
        interactor.getUserProjects(new ChooseProjectInputData(user));
    }
}