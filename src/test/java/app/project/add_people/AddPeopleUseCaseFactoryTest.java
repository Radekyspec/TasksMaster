package app.project.add_people;

import data_access.project.ProjectUserDataAccessInterface;
import entities.project.Project;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add_people.AddPeopleViewModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddPeopleUseCaseFactoryTest {

    @Test
    void create() {
        assertNotNull(AddPeopleUseCaseFactory.create(
                new ViewManagerModel(),
                new AddPeopleViewModel(),
                new MainProjectViewModel(),
                new ProjectUserDataAccessInterface() {
                    @Override
                    public List<Project> getAllProjects() {
                        return null;
                    }

                    @Override
                    public boolean addProjectMember(Project project, String username) {
                        return false;
                    }

                    @Override
                    public String getApiErrorMessage() {
                        return null;
                    }

                    @Override
                    public boolean exists(String username, Project project) {
                        return false;
                    }
                }
        ));
    }

    @Test
    void createController() {
        assertNotNull(AddPeopleUseCaseFactory.createController(
                new ViewManagerModel(),
                new MainProjectViewModel(),
                new ProjectUserDataAccessInterface() {
                    @Override
                    public List<Project> getAllProjects() {
                        return null;
                    }

                    @Override
                    public boolean addProjectMember(Project project, String username) {
                        return false;
                    }

                    @Override
                    public String getApiErrorMessage() {
                        return null;
                    }

                    @Override
                    public boolean exists(String username, Project project) {
                        return false;
                    }
                }
        ));
    }
}