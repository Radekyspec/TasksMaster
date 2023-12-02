package interface_adapter.schedule.event;

import entities.user.User;

import java.util.Date;
import java.util.List;

public class AddEventState {
    private int projectId;
    private int scheduleId;
    private String eventName;
    private String notes;
    private Date startAt;
    private Date endAt;
    private boolean isAllDay;
    private List<String> userwith;

    public void setProjectId(int projectId) { this.projectId = projectId; }

    public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }

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

    public int getProjectId() { return projectId; }

    public int getScheduleId() { return scheduleId; }

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
