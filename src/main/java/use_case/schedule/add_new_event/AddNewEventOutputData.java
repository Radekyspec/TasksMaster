package use_case.schedule.add_new_event;

import entities.event.Event;

public class AddNewEventOutputData {
    private final Event event;

    public AddNewEventOutputData(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }
}
