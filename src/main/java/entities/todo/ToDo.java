package entities.todo;

import java.util.Map;

public interface ToDo {
    /**
     * Returns target of this obj.
     * @return its target.
     */
    Integer getId();

    /**
     * Returns ID of this obj.
     * @return its ID.
     */
    String getTarget();

    /**
     * Returns the people who is assigned to this obj.
     * @return its assginto[].
     */
    String[] getAssignedTo();
}
