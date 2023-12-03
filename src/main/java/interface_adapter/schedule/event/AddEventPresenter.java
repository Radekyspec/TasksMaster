package interface_adapter.schedule.event;

import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.ScheduleViewModel;
import use_case.schedule.add_new_event.AddNewEventOutputBoundary;
import use_case.schedule.add_new_event.AddNewEventOutputData;

public class AddEventPresenter implements AddNewEventOutputBoundary{
    private final ViewManagerModel viewManagerModel;
    private final ScheduleViewModel scheduleViewModel;

    public AddEventPresenter(ViewManagerModel viewManagerModel, ScheduleViewModel scheduleViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.scheduleViewModel = scheduleViewModel;
    }

    @Override
    public void prepareSuccessView(AddNewEventOutputData addNewEventOutputData) {
        scheduleViewModel.getScheduleState().setEvent(addNewEventOutputData.getEvent());
        scheduleViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(scheduleViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
