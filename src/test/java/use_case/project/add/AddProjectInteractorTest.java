package use_case.project.add;

import data_access.project.add.AddProjectUserDataAccessInterface;
import entities.project.CommonProjectFactory;
import entities.project.Project;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddProjectInteractorTest {
    private AddProjectOutputBoundary presenter;
    private AddProjectUserDataAccessInterface userDAO;
    private AddProjectInputBoundary interactor;

    @BeforeEach
    void setUp() {
        presenter = new AddProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(AddProjectOutputData outputData) {
                assertEquals("project", outputData.project().getName());
                assertEquals("a project", outputData.project().getDescription());
            }

            @Override
            public void prepareFailView(AddProjectOutputData outputData) {
                assertTrue(outputData.useCaseFailed());
                assertEquals("Network Error", outputData.error());
            }
        };
        userDAO = new AddProjectUserDataAccessInterface() {
            @Override
            public Project createProject(User user, String name, String description) {
                if (name == null) {
                    return null;
                }
                return CommonProjectFactory.create(
                        0, name, description
                );
            }

            @Override
            public String getApiErrorMessage() {
                return "Network Error";
            }
        };
        interactor = new AddProjectInteractor(presenter, userDAO);
    }

    @Test
    void execute() {
        interactor.execute(new AddProjectInputData(null, "project", "a project"));
        interactor.execute(new AddProjectInputData(null, null, null));
    }
}