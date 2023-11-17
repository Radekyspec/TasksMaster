package entities.todo;

import java.util.Map;

public interface ToDo {
    ToDo getToDo();
    Integer getId();
    String getTarget();
    String[] getAssignedTo();
}