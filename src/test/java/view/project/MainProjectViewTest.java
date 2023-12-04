package view.project;

import entities.project.CommonProject;
import entities.project.Project;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.project.MainProjectController;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.project.add_people.AddPeopleViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.todo_panel.ToDoPanelViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.project.MainProjectInputData;
import use_case.project.MainProjectOutputBoundary;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class MainProjectViewTest {
    private MainProjectView mainProjectView;
    private MainProjectViewModel mainProjectViewModel = new MainProjectViewModel();

    @BeforeEach
    void setUp() {
        MainProjectController controller = new MainProjectController();
        mainProjectView = new MainProjectView(new ViewManagerModel(),
                new ChooseProjectViewModel(), new MainProjectViewModel(),
                new MessageBoardViewModel(), new ToDoPanelViewModel(),
                new AddPeopleViewModel(), new ScheduleViewModel());
    }

    @Test
    void actionPerformed() {
        mainProjectView.actionPerformed(new ActionEvent(new Object(), 1,""));
    }

    @Test
    void propertyChange() {
        mainProjectViewModel.getState().setProject(new CommonProject(1,"",""));
        mainProjectViewModel.firePropertyChanged();
    }

    @Test
    void getViewName() {
        assertEquals("main project", mainProjectView.getViewName());
    }
}