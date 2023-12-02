package interface_adapter.schedule;

import entities.event.Event;
import use_case.schedule.ScheduleOutputBoundary;
import use_case.schedule.ScheduleOutputData;

public class SchedulePresenter implements ScheduleOutputBoundary {
    private final ScheduleViewModel scheduleViewModel;

    public SchedulePresenter(ScheduleViewModel scheduleViewModel) {
        this.scheduleViewModel = scheduleViewModel;
    }

    /**
     * @param scheduleOutputData
     */
    @Override
    public void prepareGetEventSuccessView(ScheduleOutputData scheduleOutputData) {
        for (Event event : scheduleOutputData.getEvents()) {
            scheduleViewModel.getScheduleState().setEvent(event);
            scheduleViewModel.firePropertyChanged();
        }
    }
}
