package use_case.schedule;

import entities.user.User;

import java.util.Date;
import java.util.List;

public record ScheduleInputData(int projectId, int scheduleId, String eventName, String notes, Date startAt, Date endAt, boolean isAllDay, List<String> userWith) {
}
