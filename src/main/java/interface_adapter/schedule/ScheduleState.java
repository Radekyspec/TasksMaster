package interface_adapter.schedule;

import entities.event.Event;
import entities.project.Project;
import entities.schedule.Schedule;
import entities.user.User;

public class ScheduleState {
    private Project project;
    private User user;
    private Schedule schedule;
    private Event event;
    private int projectId;
    private int scheduleId;

    public void setProjectId(int projectId) { this.projectId = projectId; }

    public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }

    public void setEvent(Event event) { this.event = event; }

    public int getProjectId() { return projectId; }

    public int getScheduleId() { return scheduleId; }

    public Event getEvent() { return event; }

    public Project getProject() { return project; }

    public void setProject(Project project) { this.project = project; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Schedule getSchedule() { return schedule; }

    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
}
