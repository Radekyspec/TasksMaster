package interface_adapter.schedule.event;

import java.util.Date;
import java.util.List;

public class AddEventState {
    private long projectId;
    private long scheduleId;
    private String eventName;
    private String notes;
    private Date startAt;
    private Date endAt;
    private boolean isAllDay;
    private List<String> userwith;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public boolean isAllDay() {
        return isAllDay;
    }

    public void setAllDay(boolean allDay) {
        isAllDay = allDay;
    }

    public List<String> getUserwith() {
        return userwith;
    }

    public void setUserwith(List<String> userwith) {
        this.userwith = userwith;
    }
}
