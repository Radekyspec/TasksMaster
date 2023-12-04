package view.schedule;

import entities.schedule.Schedule;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleState;
import interface_adapter.schedule.ScheduleViewModel;
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
import java.util.List;
import java.util.*;

public class ScheduleView extends JPanel implements ActionListener, PropertyChangeListener{
    private User user;
    private int projectId;
    private int ScheduleId;
    private Schedule schedule;
    private final ViewManagerModel viewManagerModel;
    private final MainProjectViewModel mainProjectViewModel;
    private final ScheduleViewModel scheduleViewModel;
    private final AddEventViewModel addEventViewModel;
    private final ScheduleController scheduleController;
    private final JPanel scheduleBoard;
    private final JPanel addNewEventPanel = new JPanel();
    private final JPanel eventNameInfo = new JPanel();
    private final JPanel eventNoteInfo = new JPanel();
    private final JPanel eventStartInfo = new JPanel();
    private final JPanel eventEndInfo = new JPanel();
    private final JPanel eventAllDayInfo = new JPanel();
    private final JPanel eventUserWithInfo = new JPanel();
    private final JTextField eventNameInputField = new JTextField();
    private final JTextField eventNoteInputField = new JTextField();
    private final JTextField eventStartInputField = new JTextField();
    private final JTextField eventEndInputField = new JTextField();
    private final JTextField eventAllDayInputField = new JTextField();
    private final JTextField eventUserWithInputField = new JTextField();
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

        addNewEventPanel.add(new JLabelWithFont("Add a new event"));
        eventNameInfo.add(new JLabelWithFont(addEventViewModel.EVENT_NAME), eventNameInputField);
        eventNoteInfo.add(new JLabelWithFont(addEventViewModel.EVENT_NOTES), eventNoteInputField);
        eventStartInfo.add(new JLabelWithFont(addEventViewModel.EVENT_STARTDATE), eventStartInputField);
        eventEndInfo.add(new JLabelWithFont(addEventViewModel.EVENT_ENDDATE), eventEndInputField);
        eventAllDayInfo.add(new JLabelWithFont(addEventViewModel.EVENT_ISALLDAY), eventAllDayInputField);
        eventUserWithInfo.add(new JLabelWithFont(addEventViewModel.EVENT_USERWITH), eventUserWithInfo);
        addNewEventPanel.add(eventNameInfo);
        eventNameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        addEventViewModel.getAddEventState().setEventName(eventNameInputField.getText());
                    }
                }
        );

        eventNoteInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        addEventViewModel.getAddEventState().setNotes(eventNoteInputField.getText());
                    }
                }
        );

        eventStartInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        Date start = null;
                        try {
                            start = formatter.parse(eventStartInputField.getText());
                        } catch (ParseException ex) {
                            throw new RuntimeException(ex);
                        }
                        addEventViewModel.getAddEventState().setStartAt(start);
                    }
                }
        );

        eventEndInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        Date end = null;
                        try {
                            end = formatter.parse(eventEndInputField.getText());
                        } catch (ParseException ex) {
                            throw new RuntimeException(ex);
                        }
                        addEventViewModel.getAddEventState().setStartAt(end);
                    }
                }
        );

        eventAllDayInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        boolean allDay;
                        if (Objects.equals(eventAllDayInputField.getText(), "Y")) {
                            allDay = true;
                        } else {
                            allDay = false;
                        }
                        addEventViewModel.getAddEventState().setAllDay(allDay);
                    }
                }
        );

        eventUserWithInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        List<String> userWith = new ArrayList<String>(Arrays.asList(eventUserWithInputField.getText().split(",")));
                        addEventViewModel.getAddEventState().setUserwith(userWith);
                    }
                }
        );

        addThisEventButton = new JButtonWithFont(addEventViewModel.EVENT_POST);
        addNewEventPanel.add(addThisEventButton);
        addThisEventButton.addActionListener(
                e -> {
                    if (!e.getSource().equals(addThisEventButton)){
                        return;
                    }
                    ScheduleState state = scheduleViewModel.getScheduleState();
                    scheduleController.addEvent(state.getProjectId(), state.getProjectId(), state.getEventName(), state.getNotes(), state.getStartAt(), state.getEndAt(), state.isAllDay(), state.getUserwith());
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
        this.add(eventNameInfo);
        this.add(eventNoteInfo);
        this.add(eventStartInfo);
        this.add(eventEndInfo);
        this.add(eventAllDayInfo);
        this.add(eventUserWithInfo);
        this.add(addThisEventButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case ScheduleViewModel.SCHEDULE_SET_EVENT -> {
            }
            case ScheduleViewModel.SCHEDULE_ADD_NEW_EVENT -> {
                ScheduleState state = (ScheduleState) evt.getNewValue();
            }
        }
    }
}
