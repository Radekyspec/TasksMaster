package entities.schedule;

public class CommonScheduleFactory {
    /**
     * build up a new schedule
     *
     * @param id the id of the schedule
     */
    public static CommonSchedule create(long id) {
        return new CommonSchedule(id);
    }
}
