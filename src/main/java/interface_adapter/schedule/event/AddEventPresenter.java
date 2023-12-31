package interface_adapter.schedule.event;

import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.ScheduleViewModel;
import use_case.schedule.add_new_event.AddNewEventOutputBoundary;
import use_case.schedule.add_new_event.AddNewEventOutputData;

import javax.swing.*;

public class AddEventPresenter implements AddNewEventOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final ScheduleViewModel scheduleViewModel;

    public AddEventPresenter(ViewManagerModel viewManagerModel, ScheduleViewModel scheduleViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.scheduleViewModel = scheduleViewModel;
    }

    @Override
    public void prepareSuccessView(AddNewEventOutputData addNewEventOutputData) {
        scheduleViewModel.getScheduleState().setEvent(addNewEventOutputData.getEvent());
        scheduleViewModel.firePropertyChanged(ScheduleViewModel.SCHEDULE_ADD_NEW_EVENT);
        viewManagerModel.setActiveView(scheduleViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        JOptionPane.showMessageDialog(null, AddEventViewModel.EVENT_POST_FAIL);
    }
}
