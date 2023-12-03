package use_case.todo_panel;

import entities.todo_list.ToDoList;

import java.util.List;

public class ImportToDoListOutputData {
    private final List<ToDoList> listOfToDo;
    private final String error;
    private final long projectID;
    private final long toDoPanelID;
    private final boolean useCaseFailed;
    public ImportToDoListOutputData(String error, boolean useCaseFailed,
                                    long projectID, long toDoPanelID,
                                    List<ToDoList> listOfToDo) {
        this.listOfToDo = listOfToDo;
        this.error = error;
        this.useCaseFailed = useCaseFailed;
        this.projectID = projectID;
        this.toDoPanelID = toDoPanelID;
    }
    public String getError() {
        return error;
    }
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public List<ToDoList> getListOfToDo() {
        return listOfToDo;
    }
}
