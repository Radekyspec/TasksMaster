package use_case.todo_list;

import entities.todo_list.ToDoList;

import java.util.Map;

public class ToDoListOutputData {
    private final String error;
    private final boolean useCaseFailed;
    private final Map<Integer, ToDoList> toDoListPackage;
    private final String ID;
    private final String name;
    private final String detail;
    private final String workKind;


    /**
     * Standard todolist output data.
     * @param error String describing error. Set in interactor.
     * @param useCaseFailed boolean, is use case failed.
     * @param ID If "create", the ID of the todolist.
     * @param name If "create", the name of the todolist.
     * @param detail If "create", the detail of the todolist.
     * @param toDoListPackage If "import", a map contains imported todolists.
     */

    public ToDoListOutputData(String workKind,
                              String error, boolean useCaseFailed,
                              String ID, String name, String detail,
                              Map<Integer, ToDoList> toDoListPackage) {
        this.error = error;
        this.useCaseFailed = useCaseFailed;
        this.toDoListPackage = toDoListPackage;
        this.ID = ID;
        this.name = name;
        this.detail = detail;
        this.workKind = workKind;
    }

    public String getError() {
        return error;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public Map<Integer, ToDoList> getToDoListPackage() {
        return toDoListPackage;
    }

    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public String getWorkKind() {
        return workKind;
    }
}
