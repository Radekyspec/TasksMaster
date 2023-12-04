package use_case.schedule;

import entities.event.Event;

import java.util.List;

public record ScheduleOutputData(List<Event> events) {
}
