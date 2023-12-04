package interface_adapter.schedule;

import entities.event.Event;
import use_case.schedule.ScheduleOutputBoundary;
import use_case.schedule.ScheduleOutputData;

import javax.swing.*;

public class SchedulePresenter implements ScheduleOutputBoundary {
    private final ScheduleViewModel scheduleViewModel;

    public SchedulePresenter(ScheduleViewModel scheduleViewModel) {
        this.scheduleViewModel = scheduleViewModel;
    }

    @Override
    public void prepareGetEventSuccessView(ScheduleOutputData scheduleOutputData) {
        for (Event event : scheduleOutputData.events()) {
            scheduleViewModel.getScheduleState().setProjectId(event.getID());
            scheduleViewModel.getScheduleState().setEvent(event);
            scheduleViewModel.firePropertyChanged(ScheduleViewModel.SCHEDULE_ADD_NEW_EVENT);
        }
    }

    public void prepareGetEventFailView() {
        JOptionPane.showMessageDialog(null, ScheduleViewModel.SCHEDULE_NO_EVENT);
    }
}
