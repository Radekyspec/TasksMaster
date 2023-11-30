package entities.todo;

public interface ToDo {
    /**
     * Returns target of this obj.
     *
     * @return its target.
     */
    Integer getID();

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
     * @return incomplete when it isn't complete, done when it's complete.
     */
    String getProgress();
}
