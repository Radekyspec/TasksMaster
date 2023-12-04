package app.project.choose;

import data_access.project.choose.ChooseProjectUserDataAccessInterface;
import entities.project.Project;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ChooseProjectUseCaseFactoryTest {

    @Test
    void create() {
        assertNotNull(ChooseProjectUseCaseFactory.create(
                new ViewManagerModel(),
                new AddProjectViewModel(),
                new ChooseProjectViewModel(),
                new MainProjectViewModel(),
                new ChooseProjectUserDataAccessInterface() {
                    @Override
                    public List<Project> getUserProjects(User user) {
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
        assertNotNull(ChooseProjectUseCaseFactory.createController(
                new ChooseProjectViewModel(),
                new MainProjectViewModel(),
                new ViewManagerModel(),
                new ChooseProjectUserDataAccessInterface() {
                    @Override
                    public List<Project> getUserProjects(User user) {
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