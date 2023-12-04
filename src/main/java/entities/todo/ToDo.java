package entities.todo;

public interface ToDo {
    final String TODO_INCOMPLETE = "incomplete";
    final String TODO_COMPLETE = "complete";

    /**
     * Returns target of this obj.
     *
     * @return its target.
     */
    long getID();

    /**
     * Returns ID of this obj.
     *
     * @return its ID.
     */
    String getTarget();

    /**
     * Returns the people who assignTo this obj.
     *
     * @return its assignTo[].
     */
    String[] getAssignedTo();

    /**
     * Return if the to_do is finished.
     *
     * @return "incomplete" when it isn't complete, done when it's "complete".
     */
    String getProgress();

    /**
     * Return [ ] if it's unfinished, and return [x] if it's finished.
     *
     * @return a string that graphically shows finish or not.
     */
    String getCharProgress();
}
