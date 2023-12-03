package view.schedule;

import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.event.AddEventController;
import interface_adapter.schedule.event.AddEventState;
import interface_adapter.schedule.event.AddEventViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddNewEventView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final AddEventViewModel addEventViewModel;
    private final AddEventController addEventController;
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
    private final JButton postButton;

    public AddNewEventView(ViewManagerModel viewManagerModel, AddEventViewModel addEventViewModel, AddEventController addEventController) {
        this.viewManagerModel = viewManagerModel;
        this.addEventViewModel = addEventViewModel;
        this.addEventController = addEventController;
        eventNameInfo.add(new JLabel(addEventViewModel.EVENT_NAME), eventNameInputField);
        eventNoteInfo.add(new JLabel(addEventViewModel.EVENT_NOTES), eventNoteInputField);
        eventStartInfo.add(new JLabel(addEventViewModel.EVENT_STARTDATE), eventStartInputField);
        eventEndInfo.add(new JLabel(addEventViewModel.EVENT_ENDDATE), eventEndInputField);
        eventAllDayInfo.add(new JLabel(addEventViewModel.EVENT_ISALLDAY), eventAllDayInputField);
        eventUserWithInfo.add(new JLabel(addEventViewModel.EVENT_USERWITH), eventUserWithInfo);
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

        postButton = new JButton(addEventViewModel.EVENT_POST);
        postButton.addActionListener(
                e -> {
                    AddEventState state = addEventViewModel.getAddEventState();
                    addEventController.postEvent(state.getProjectId(), state.getProjectId(), state.getEventName(), state.getNotes(), state.getStartAt(), state.getEndAt(), state.isAllDay(), state.getUserwith());
                }
        );
        this.add(eventNameInfo);
        this.add(eventNoteInfo);
        this.add(eventStartInfo);
        this.add(eventEndInfo);
        this.add(eventAllDayInfo);
        this.add(eventUserWithInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
