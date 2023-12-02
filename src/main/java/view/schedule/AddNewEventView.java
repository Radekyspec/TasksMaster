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
    //private final JButton postButton;

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
