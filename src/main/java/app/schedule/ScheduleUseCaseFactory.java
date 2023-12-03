package app.schedule;

import data_access.schedule.ScheduleDataAccessInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.schedule.SchedulePresenter;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.schedule.ScheduleController;

import interface_adapter.schedule.event.AddEventViewModel;
import use_case.schedule.ScheduleInputBoundary;
import use_case.schedule.ScheduleInteractor;
import use_case.schedule.ScheduleOutputBoundary;
import view.schedule.ScheduleView;

public class ScheduleUseCaseFactory {
    private ScheduleUseCaseFactory() {

    }

    public static ScheduleView create(ViewManagerModel viewManagerModel, MainProjectViewModel mainProjectViewModel, ScheduleViewModel scheduleViewModel, AddEventViewModel addEventViewModel, ScheduleDataAccessInterface scheduleDataAccessInterface) {
        return  new ScheduleView(viewManagerModel,mainProjectViewModel,scheduleViewModel,addEventViewModel,ScheduleUseCaseFactory.createController(scheduleViewModel, scheduleDataAccessInterface));
    }

    public static ScheduleController createController(ScheduleViewModel scheduleViewModel, ScheduleDataAccessInterface scheduleDataAccessInterface) {
        ScheduleOutputBoundary schedulePresenter = new SchedulePresenter(scheduleViewModel);
        ScheduleInputBoundary scheduleInteractor = new ScheduleInteractor(scheduleDataAccessInterface, schedulePresenter);
        return new ScheduleController(scheduleInteractor);
    }
}
