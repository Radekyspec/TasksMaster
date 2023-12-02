package data_access.todo;

import entities.todo_list.ToDoList;

public interface ToDoDataAccessInterface {
    /**
     * Put data into a new & empty To_Do object.
     * (for convenient create & sync)
     * @param projectID Proj. that this List belongs to.
     * @param toDoListID TDL. that this List belongs to.
     * @return a To_Do with those data.
     */
    ToDoList createToDo(Integer projectID, Integer toDoListID);

    /**
     * namely
     * @return A string which is the Api error Message.
     */
    String getApiErrorMessage();
}
