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
     * Put data into a new & empty ToDoList object.
     * (for convenient create & sync)
     * @param projectID Proj. that this List belongs to.
     * @param toDoPanelID TDP. that this List belongs to.
     * @return a ToDoList with those data.
     */
    ToDoList createToDoList(Integer projectID, Integer toDoPanelID);
}
