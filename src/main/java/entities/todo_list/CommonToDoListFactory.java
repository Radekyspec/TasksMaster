package entities.todo_list;

public class CommonToDoListFactory {
    /**
     * create a CommonToDoList class that contains things as followed.
     *
     * @param listID the identification of this To_DoList
     * @param name   the name of this list
     * @param detail a brief description word that talks about this To_DoList.
     * @return a CommonToDoList
     */
    public static CommonToDoList create(long listID, long projectID, String name, String detail) {
        return new CommonToDoList(listID, projectID, name, detail);
    }
}
