package use_case.schedule.add_new_event;

import entities.user.User;

import java.util.Date;
import java.util.List;

public class AddNewEventInputData {
    private int projectId;
    private int scheduleId;
    private String eventName;
    private String notes;
    private Date startAt;
    private Date endAt;
    private boolean isAllDay;
    private List<String> userWith;

    public AddNewEventInputData(int projectId, int scheduleId, String eventName, String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userWith) {
        this.projectId = projectId;
        this.scheduleId = scheduleId;
        this.eventName = eventName;
        this.notes = notes;
        this.startAt = startAt;
        this.endAt = endAt;
        this.isAllDay = isAllDay;
        this.userWith = userWith;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public String getEventname() {
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

    public boolean getIsAllDay() {
        return isAllDay;
    }

    public List<String> getUserWith() {
        return userWith;
    }
}
