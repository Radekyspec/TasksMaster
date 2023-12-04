package app.schedule.add_new_event;

import data_access.schedule.ScheduleDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.schedule.event.AddEventController;
import interface_adapter.schedule.event.AddEventPresenter;
import interface_adapter.schedule.event.AddEventViewModel;
import use_case.schedule.add_new_event.AddNewEventInputBoundary;
import use_case.schedule.add_new_event.AddNewEventInteractor;
import use_case.schedule.add_new_event.AddNewEventOutputBoundary;
import view.schedule.AddNewEventView;

public class AddNewEventUseCaseFactory {
    private AddNewEventUseCaseFactory() {
    }

    public static AddNewEventView create(ViewManagerModel viewManagerModel, AddEventViewModel addEventViewModel, ScheduleViewModel scheduleViewModel, ScheduleDataAccessInterface scheduleDataAccessInterface) {
        return new AddNewEventView(viewManagerModel, addEventViewModel, scheduleViewModel, AddNewEventUseCaseFactory.createContorller(viewManagerModel, scheduleViewModel, scheduleDataAccessInterface));
    }

    public static AddEventController createContorller(ViewManagerModel viewManagerModel, ScheduleViewModel scheduleViewModel, ScheduleDataAccessInterface scheduleDataAccessInterface) {
        AddNewEventOutputBoundary addNewEventPresenter = new AddEventPresenter(viewManagerModel, scheduleViewModel);
        AddNewEventInputBoundary addNewEventInteractor = new AddNewEventInteractor(scheduleDataAccessInterface, addNewEventPresenter);
        return new AddEventController(addNewEventInteractor);
    }
}
