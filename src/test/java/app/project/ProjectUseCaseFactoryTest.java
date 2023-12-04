package app.project;

import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add_people.AddPeopleViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProjectUseCaseFactoryTest {

    @Test
    void create() {
        assertNotNull(ProjectUseCaseFactory.create(
                new ViewManagerModel(),
                new ChooseProjectViewModel(),
                new MainProjectViewModel(),
                new MessageBoardViewModel(),
                new ToDoPanelViewModel(),
                new AddPeopleViewModel(),
                new ScheduleViewModel()
        ));
    }
}