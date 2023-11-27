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
     * Returns the people who is assigned to this obj.
     *
     * @return its assginto[].
     */
    String[] getAssignedTo();
}
