package view.project.choose;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectController;
import interface_adapter.project.choose.ChooseProjectViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.project.choose.ChooseProjectInputBoundary;
import use_case.project.choose.ChooseProjectInputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class ChooseProjectViewTest {
    private ChooseProjectView chooseProjectView;
    private ChooseProjectViewModel chooseProjectViewModel = new ChooseProjectViewModel();

    @BeforeEach
    void setUp(){
        ChooseProjectController controller = new ChooseProjectController(new ChooseProjectInputBoundary() {
            @Override
            public void execute(ChooseProjectInputData inputData) {

            }

            @Override
            public void getUserProjects(ChooseProjectInputData inputData) {

            }
        });
        chooseProjectView = new ChooseProjectView(new ViewManagerModel(), new AddProjectViewModel(), new ChooseProjectViewModel(), controller);
    }
    @Test
    void propertyChange() {
        chooseProjectViewModel.getState().setChooseProjectError("error message test");
        Timer t = new Timer(2000, e -> {for (Window window : Window.getWindows()) {
            if (window instanceof JDialog) {
                window.dispose();
            }
        }});
        t.setRepeats(false);
        t.start();
        chooseProjectViewModel.firePropertyChanged();
    }

    @Test
    void actionPerformed() {
        chooseProjectView.actionPerformed(new ActionEvent(new Object(), 1, ""));
    }

    @Test
    void getViewName() {
        assertEquals(chooseProjectView.getViewName(), "choose project");
    }
}