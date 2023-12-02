package view.schedule;

import entities.event.Event;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.ScheduleController;
import interface_adapter.schedule.SchedulePresenter;
import interface_adapter.schedule.ScheduleState;
import interface_adapter.schedule.ScheduleViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScheduleView extends JPanel implements ActionListener, PropertyChangeListener{
    private User user;
    private final ViewManagerModel viewManagerModel;
    private final EventViewModel eventViewModel;
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
