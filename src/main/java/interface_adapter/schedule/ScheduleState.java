package interface_adapter.schedule;

import entities.event.Event;

public class ScheduleState {
    private Event event;
    private int projectId;
    private int scheduleId;

    public ScheduleState(int projectId, int scheduleId) {
        this.projectId = projectId;
        this.scheduleId = scheduleId;
    }

    public void setProjectId(int projectId) { this.projectId = projectId; }

    public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }

    public void setEvent(Event event) { this.event = event; }

    public int getProjectId() { return projectId; }

    public int getScheduleId() { return scheduleId; }

    public Event getEvent() { return event; }
}
