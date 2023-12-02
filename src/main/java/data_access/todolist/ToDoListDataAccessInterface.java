package data_access.todolist;

import entities.todo.ToDo;
import entities.todo_list.ToDoList;
import entities.todo_panel.ToDoPanel;

import java.util.List;
import java.util.Map;

public interface ToDoListDataAccessInterface {
    /**
     * Get to_dos from api.
     * @param projectID namely.
     * @param toDoListID namely.
     * @return A list of To_Do.
     */
    List<ToDo> importToDo(Integer projectID, Integer toDoListID);

    /**
     * namely
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
