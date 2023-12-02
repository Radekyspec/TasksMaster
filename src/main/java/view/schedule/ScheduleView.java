package view.schedule;

import entities.user.User;
import entities.schedule.Schedule;
import entities.event.Event;
import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.ScheduleState;

import javax.swing.*;
import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScheduleView extends JPanel implements ActionListener, PropertyChangeListener{
    private User user;
    private final ViewManagerModel viewManagerModel;
    private final ScheduleViewModel scheduleViewModel;
    //private final EventViewModel eventViewModel;
    //private final AddNewEventViewModel addNewEventViewModel;
    private final ScheduleController scheduleController;
    private final JButton addNewEvent;
    private final JPanel addEventPanel = new JPanel();
    //private final JPanel;

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public ScheduleView(User user, ViewManagerModel viewManagerModel, ScheduleViewModel scheduleViewModel, ScheduleController scheduleController, JButton addNewEvent) {
        this.user = user;
        this.viewManagerModel = viewManagerModel;
        this.scheduleViewModel = scheduleViewModel;
        this.scheduleController = scheduleController;
        this.addNewEvent = addNewEvent;
    }
}
