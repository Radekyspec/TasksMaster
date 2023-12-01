package use_case.todo_list;

import entities.todo_list.ToDoList;

import java.util.Map;

public class ToDoListInputData {
    private final String workKind;
    private final String ID;
    private final String name;
    private final String detail;
    private final Map<Integer, ToDoList> toDoListPackage;

    /**
     * Initialize a standard ToDoListInputData.
     * @param workKind kind of work, which are: "import" and "create"
     * @param ID ID of the future TDL, if it is "create" a TDL.
     * @param name name of the future TDL, if it is "create" a TDL.
     * @param detail detail of the future TDL, if it is "create" a TDL.
     * @param toDoListPackage a map of ToDoList, if it is "import" TDL(s).
     */
    public ToDoListInputData(String workKind,
                             String ID, String name, String detail,
                             Map<Integer, ToDoList> toDoListPackage) {
        this.ID = ID;
        this.name = name;
        this.detail = detail;
        this.toDoListPackage = toDoListPackage;
        this.workKind = workKind;
    }

    /**
     * Namely
     * @return workKind
     */
    public String getWorkKind() {
        return workKind;
    }

    /**
     * Namely
     * @return ID, only for "create"
     */
    public String getID() {
        return ID;
    }

    /**
     * Namely
     * @return detail, only for "create"
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Namely
     * @return name, only for "create"
     */
    public String getName() {
        return name;
    }

    /**
     * Namely
     * @return a map of ToDoList, only for "import"
     */
    public Map<Integer, ToDoList> getToDoListPackage() {
        return toDoListPackage;
    }
}
