package app.project.add;

import data_access.project.add.AddProjectUserDataAccessInterface;
import entities.project.Project;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AddProjectUseCaseFactoryTest {

    @Test
    void create() {
        assertNotNull(AddProjectUseCaseFactory.create(
                new ViewManagerModel(),
                new AddProjectViewModel(),
                new ChooseProjectViewModel(),
                new AddProjectUserDataAccessInterface() {
                    @Override
                    public Project createProject(User user, String name, String description) {
                        return null;
                    }

                    @Override
                    public String getApiErrorMessage() {
                        return null;
                    }
                }
        ));
    }

    @Test
    void createController() {
        assertNotNull(AddProjectUseCaseFactory.createController(
                new ViewManagerModel(),
                new AddProjectViewModel(),
                new ChooseProjectViewModel(),
                new AddProjectUserDataAccessInterface() {
                    @Override
                    public Project createProject(User user, String name, String description) {
                        return null;
                    }

                    @Override
                    public String getApiErrorMessage() {
                        return null;
                    }
                }
        ));
    }
}