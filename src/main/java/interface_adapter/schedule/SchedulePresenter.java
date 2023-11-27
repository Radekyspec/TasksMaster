package interface_adapter.schedule;

import interface_adapter.ViewManagerModel;
import use_case.schedule.ScheduleOutputBoundary;
import use_case.schedule.ScheduleOutputData;

public class SchedulePresenter implements ScheduleOutputBoundary {
    private final ScheduleViewModel scheduleViewModel;
    private final ViewManagerModel viewManagerModel;

    public SchedulePresenter(ScheduleViewModel scheduleViewModel, ViewManagerModel viewManagerModel) {
        this.scheduleViewModel = scheduleViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ScheduleOutputData scheduleOutputData) {
        //TODO viewManagerModel.setActiveView(scheduleViewModel.);
    }

    public void prepareFailView(ScheduleOutputData scheduleOutputData) {
    }
}
