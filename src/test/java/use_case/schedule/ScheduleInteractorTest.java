package use_case.schedule;

import data_access.schedule.ScheduleDataAccessInterface;
import entities.event.CommonEvent;
import entities.event.CommonEventFactory;
import entities.event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleInteractorTest {
    private ScheduleOutputBoundary presenter;
    private ScheduleInputBoundary interactor;
    private ScheduleDataAccessInterface userDAO;

    @BeforeEach
    void setUp() {
        presenter = new ScheduleOutputBoundary() {
            @Override
            public void prepareGetEventSuccessView(ScheduleOutputData scheduleOutputData) {

            }

            @Override
            public void prepareGetEventFailView() {

            }
        };
        userDAO = new ScheduleDataAccessInterface() {
            @Override
            public List<Event> getEvents(long projectId, long scheduleid) {
                if (scheduleid == 0) {
                    return null;
                } else if (projectId == scheduleid) {
                    return new ArrayList<>();
                }
                List<Event> events = new ArrayList<>();
                try {
                    events.add(CommonEventFactory.create(
                            0, "", "",
                            new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-01"),
                            new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-01"),
                            true
                    ));
                    return events;
                } catch (ParseException e) {
                    fail("Parse Date error");
                    return null;
                }
            }

            @Override
            public Event addEvents(long projectId, long scheduleId, String eventName, String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userWith) {
                if (projectId == 0) {
                    return null;
                }
                try {
                    return CommonEventFactory.create(
                            0, "", "",
                            new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-01"),
                            new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-01"),
                            true
                    );
                } catch (ParseException e) {
                    fail("parse date error");
                    return null;
                }

            }
        };
        interactor = new ScheduleInteractor(userDAO, presenter);
    }

    @Test
    void getEvent() {
        interactor.getEvent(new ScheduleInputData(0, 0, null, null, null, null, true, null));
        interactor.getEvent(new ScheduleInputData(0, 2, null, null, null, null, true, null));
        interactor.getEvent(new ScheduleInputData(3, 0, null, null, null, null, true, null));
    }

    @Test
    void addEvent() {
        interactor.addEvent(new ScheduleInputData(0, 333, null, null, null, null, true, null));
        interactor.addEvent(new ScheduleInputData(114514, 333, null, null, null, null, true, null));
    }
}