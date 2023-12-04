package view.schedule;

import entities.event.Event;
import entities.schedule.Schedule;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleState;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.schedule.event.AddEventState;
import interface_adapter.schedule.event.AddEventViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class ScheduleView extends JPanel implements ActionListener, PropertyChangeListener{
    private long projectId;
    private long scheduleId;
    private Schedule schedule;
    private final ViewManagerModel viewManagerModel;
    private final MainProjectViewModel mainProjectViewModel;
    private final ScheduleViewModel scheduleViewModel;
    private final ScheduleController scheduleController;
    private final AddEventViewModel addEventViewModel;
    private final JPanel scheduleBoard;

    private JButton addThisEventButton = new JButton();

    public ScheduleView(ViewManagerModel viewManagerModel, MainProjectViewModel mainProjectViewModel, ScheduleViewModel scheduleViewModel, AddEventViewModel addEventViewModel, ScheduleController scheduleController) {
        this.viewManagerModel = viewManagerModel;
        this.mainProjectViewModel = mainProjectViewModel;
        this.scheduleViewModel = scheduleViewModel;
        this.addEventViewModel = addEventViewModel;
        this.scheduleController = scheduleController;
        scheduleViewModel.addPropertyChangeListener(this);

        scheduleBoard = new JPanel();
        ScheduleState scheduleState = scheduleViewModel.getScheduleState();
        //for (Event event : scheduleController.getEvent(scheduleState.getProjectId(), scheduleState.getScheduleId()) ) {
        //    return ;
        //}

        addThisEventButton = new JButtonWithFont(ScheduleViewModel.SCHEDULE_ADD_NEW_EVENT);
        addThisEventButton.addActionListener(
                e -> {
                    if (!e.getSource().equals(addThisEventButton)){
                        return;
                    }
                    viewManagerModel.setActiveView(addEventViewModel.getViewName());
                    AddEventState addEventState = addEventViewModel.getAddEventState();
                    addEventState.setProjectId(scheduleViewModel.getScheduleState().getProjectId());
                    addEventState.setScheduleId(scheduleViewModel.getScheduleState().getScheduleId());
                    viewManagerModel.firePropertyChanged();
                }
        );

        JButton back = new JButtonWithFont("Back");
        back.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(mainProjectViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        JLabel title = new JLabelWithFont(ScheduleViewModel.SCHEDULE_TITLE_LABEL, Font.BOLD, 26);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createVerticalGlue());
        this.add(scheduleBoard);
        this.add(Box.createVerticalGlue());
        JPanel botton = new JPanel();
        botton.add(addThisEventButton);
        botton.add(back);
        this.add(botton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ScheduleState state = (ScheduleState) evt.getNewValue();
        switch (evt.getPropertyName()) {
            case ScheduleViewModel.SCHEDULE_SET_EVENT -> {
                this.projectId = state.getProjectId();
                this.scheduleId = state.getScheduleId();
                scheduleController.getEvent(projectId, scheduleId);
            }
            case ScheduleViewModel.SCHEDULE_ADD_NEW_EVENT -> {
                Event event = state.getEvent();
                JButton addThisEventButton = new JButtonWithFont();
                addThisEventButton.addActionListener(this);
                addThisEventButton.setPreferredSize(new Dimension(100,35));
            }
        }
    }
    public String getViewName() {
        return scheduleViewModel.getViewName();
    }
}
