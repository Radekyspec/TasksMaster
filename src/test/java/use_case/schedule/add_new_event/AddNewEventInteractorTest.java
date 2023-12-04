package use_case.schedule.add_new_event;

import data_access.schedule.ScheduleDataAccessInterface;
import entities.event.CommonEventFactory;
import entities.event.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

class AddNewEventInteractorTest {
    private AddNewEventOutputBoundary presenter;
    private AddNewEventInputBoundary interactor;
    private ScheduleDataAccessInterface userDAO;

    @BeforeEach
    void setUp() {
        presenter = new AddNewEventOutputBoundary() {
            @Override
            public void prepareSuccessView(AddNewEventOutputData addNewEventOutputData) {

            }

            @Override
            public void prepareFailView() {

            }
        };
        userDAO = new ScheduleDataAccessInterface() {
            @Override
            public List<Event> getEvents(long projectId, long scheduleid) {
                return null;
            }

            @Override
            public Event addEvents(long projectId, long scheduleId, String eventName, String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userWith) {
                if (projectId == 0) {
                    return null;
                }
                return CommonEventFactory.create(
                        0, "", "", null, null, true
                );
            }
        };
        interactor = new AddNewEventInteractor(userDAO, presenter);
    }

    @Test
    void postEvent() {
        interactor.postEvent(new AddNewEventInputData(0, 0, "", "", null, null, true, null));
        interactor.postEvent(new AddNewEventInputData(514, 114, "", "", null, null, true, null));
    }
}