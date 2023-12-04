package app.schedule;

import data_access.InMemoryUserDataAccessObject;
import data_access.schedule.ScheduleDataAccessInterface;
import entities.event.Event;
import interface_adapter.ViewManagerModel;
import interface_adapter.project.MainProjectViewModel;
import interface_adapter.schedule.ScheduleViewModel;
import interface_adapter.schedule.event.AddEventViewModel;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleUseCaseFactoryTest {

    @Test
    void create() {
        assertNotNull(ScheduleUseCaseFactory.create(
                new ViewManagerModel(),
                new MainProjectViewModel(),
                new ScheduleViewModel(),
                new AddEventViewModel(),
                new ScheduleDataAccessInterface() {
                    @Override
                    public List<Event> getEvents(long projectId, long scheduleid) {
                        return null;
                    }

                    @Override
                    public Event addEvents(long projectId, long scheduleId, String eventName, String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userWith) {
                        return null;
                    }
                }
        ));
    }

    @Test
    void createController() {
        assertNotNull(ScheduleUseCaseFactory.createController(
                new ScheduleViewModel(),
                new ScheduleDataAccessInterface() {
                    @Override
                    public List<Event> getEvents(long projectId, long scheduleid) {
                        return null;
                    }

                    @Override
                    public Event addEvents(long projectId, long scheduleId, String eventName, String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userWith) {
                        return null;
                    }
                }
        ));
    }
}