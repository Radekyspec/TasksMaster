package interface_adapter.schedule;

import entities.event.Event;
import entities.project.Project;
import entities.schedule.Schedule;
import entities.user.User;

import java.util.Date;
import java.util.List;

public class ScheduleState {
    private Event event;
    private Schedule schedule;
    private long projectId;
    private long scheduleId;
    private String eventName;
    private String notes;
    private Date startAt;
    private Date endAt;
    private boolean isAllDay;
    private List<String> userwith;

    public void setEvent(Event event) { this.event = event; }

    public void setSchedule(Schedule schedule) { this.schedule = schedule; }

    public void setProjectId(long projectId) { this.projectId = projectId; }

    public void setScheduleId(long scheduleId) { this.scheduleId = scheduleId; }

    public void setEventName(String eventName) { this.eventName = eventName; }

    public void setNotes(String notes) { this.notes = notes; }

    public void setStartAt(Date startAt) { this.startAt = startAt; }

    public void setEndAt(Date endAt) { this.endAt = endAt; }

    public void setAllDay(boolean allDay) {
        isAllDay = allDay;
    }

    public void setUserwith(List<String> userwith) {
        this.userwith = userwith;
    }

    public Event getEvent() { return this.event; }

    public Schedule getSchedule() { return this.schedule; }

    public long getProjectId() { return projectId; }

    public long getScheduleId() { return scheduleId; }

    public String getEventName() {
        return eventName;
    }

    public String getNotes() {
        return notes;
    }

    public Date getStartAt() {
        return startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public boolean isAllDay() {
        return isAllDay;
    }

    public List<String> getUserwith() {
        return userwith;
    }
}
