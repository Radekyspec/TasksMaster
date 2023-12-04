package view.project.add;

import interface_adapter.ViewManagerModel;
import interface_adapter.project.add.AddProjectController;
import interface_adapter.project.add.AddProjectViewModel;
import interface_adapter.project.choose.ChooseProjectViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.project.add.AddProjectInputBoundary;
import use_case.project.add.AddProjectInputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class AddProjectViewTest {
    private AddProjectView addProjectView;
    private AddProjectViewModel addProjectViewModel = new AddProjectViewModel();

    @BeforeEach
    void setUp() {
        AddProjectController controller = new AddProjectController(new AddProjectInputBoundary() {
            @Override
            public void execute(AddProjectInputData inputData) {

            }
        });
        addProjectView = new AddProjectView(new ViewManagerModel(), new AddProjectViewModel(), controller, new ChooseProjectViewModel());
    }

    @Test
    void propertyChange() {
        addProjectViewModel.getState().setAddError("error message test");
        Timer t = new Timer(1000, e -> {for (Window window : Window.getWindows()) {
            if (window instanceof JDialog) {
                window.dispose();
            }
        }});
        addProjectViewModel.firePropertyChanged();
    }

    @Test
    void actionPerformed() {
        addProjectView.actionPerformed(new ActionEvent(new Object(), 1, ""));
    }

    @Test
    void getViewName() {
        assertEquals("add project", addProjectView.getViewName());
    }
}