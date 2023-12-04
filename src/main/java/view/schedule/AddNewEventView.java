package view.schedule;

import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.schedule.event.AddEventController;
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
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class AddNewEventView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final AddEventViewModel addEventViewModel;
    private final AddEventController addEventController;
    private final ScheduleViewModel scheduleViewModel;
    private final JPanel eventNameInfo = new JPanel();
    private final JPanel eventNoteInfo = new JPanel();
    private final JPanel eventStartInfo = new JPanel();
    private final JPanel eventEndInfo = new JPanel();
    private final JPanel eventAllDayInfo = new JPanel();
    private final JPanel eventUserWithInfo = new JPanel();
    private final JTextField eventNameInputField = new JTextField(30);
    private final JTextField eventNoteInputField = new JTextField(30);
    private final JTextField eventStartInputField = new JTextField(30);
    private final JTextField eventEndInputField = new JTextField(30);
    private final JTextField eventAllDayInputField = new JTextField(30);
    private final JTextField eventUserWithInputField = new JTextField(30);
    private final JButton postButton;

    public AddNewEventView(ViewManagerModel viewManagerModel, AddEventViewModel addEventViewModel, ScheduleViewModel scheduleViewModel, AddEventController addEventController) {
        this.viewManagerModel = viewManagerModel;
        this.addEventViewModel = addEventViewModel;
        this.addEventController = addEventController;
        this.scheduleViewModel = scheduleViewModel;
        addEventViewModel.addPropertyChangeListener(this);

        eventNameInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        eventNoteInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        ;
        eventStartInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        eventEndInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        eventAllDayInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
//        eventUserWithInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));

        eventNameInfo.add(new JLabelWithFont(AddEventViewModel.EVENT_NAME));
        eventNameInfo.add(eventNameInputField);
        eventNoteInfo.add(new JLabelWithFont(AddEventViewModel.EVENT_NOTES));
        eventNoteInfo.add(eventNoteInputField);
        eventStartInfo.add(new JLabelWithFont(AddEventViewModel.EVENT_STARTDATE));
        eventStartInfo.add(eventStartInputField);
        eventEndInfo.add(new JLabelWithFont(AddEventViewModel.EVENT_ENDDATE));
        eventEndInfo.add(eventEndInputField);
        eventAllDayInfo.add(new JLabelWithFont(AddEventViewModel.EVENT_ISALLDAY));
        eventAllDayInfo.add(eventAllDayInputField);
//        eventUserWithInfo.add(new JLabelWithFont(AddEventViewModel.EVENT_USERWITH));
//        eventUserWithInfo.add(eventUserWithInputField);

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

        final String[] stringStartAt = new String[1];
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
                        stringStartAt[0] = eventStartInputField.getText();
                    }
                }
        );

        final String[] stringEndAt = new String[1];
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
                        stringEndAt[0] = eventEndInputField.getText();
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

//        eventUserWithInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                        List<String> userWith = new ArrayList<String>(Arrays.asList(eventUserWithInputField.getText().split(",")));
//                        addEventViewModel.getAddEventState().setUserwith(userWith);
//                    }
//                }
//        );

        postButton = new JButtonWithFont(AddEventViewModel.EVENT_POST);
        postButton.addActionListener(
                e -> {
                    if (!e.getSource().equals(postButton)) {
                        return;
                    }
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    Date start = null;
                    try {
                        start = formatter.parse(stringStartAt[0]);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    addEventViewModel.getAddEventState().setStartAt(start);

                    Date end = null;
                    try {
                        end = formatter.parse(stringEndAt[0]);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    addEventViewModel.getAddEventState().setEndAt(end);

                    AddEventState state = addEventViewModel.getAddEventState();
                    addEventController.postEvent(state.getProjectId(), state.getScheduleId(), state.getEventName(), state.getNotes(), state.getStartAt(), state.getEndAt(), state.isAllDay(), state.getUserwith());
                }
        );

        JButton back = new JButtonWithFont("Back");
        back.addActionListener(
                e -> {
                    viewManagerModel.setActiveView(scheduleViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        this.add(new JLabelWithFont("Add a new event"));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(eventNameInfo);
        eventNameInfo.setAlignmentX(CENTER_ALIGNMENT);
        this.add(eventNoteInfo);
        eventNoteInfo.setAlignmentX(CENTER_ALIGNMENT);
        this.add(eventStartInfo);
        eventStartInfo.setAlignmentX(CENTER_ALIGNMENT);
        this.add(eventEndInfo);
        eventEndInfo.setAlignmentX(CENTER_ALIGNMENT);
        this.add(eventAllDayInfo);
        eventAllDayInfo.setAlignmentX(CENTER_ALIGNMENT);
//        this.add(eventUserWithInfo);
//        eventUserWithInfo.setAlignmentX(CENTER_ALIGNMENT);
        JPanel bottom = new JPanel();
        bottom.add(postButton);
        bottom.add(back);
        this.add(bottom);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    public String getViewName() {
        return addEventViewModel.getViewName();
    }
}
