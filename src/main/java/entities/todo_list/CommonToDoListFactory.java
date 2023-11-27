package entities.todo_list;

public class CommonToDoListFactory {
    /**
     * create a CommonToDoList class that contains things as followed.
     *
     * @param ID     the identification of this To_DoList
     * @param name   the name of this list
     * @param detail a brief description word that talks about this To_DoList.
     * @return a CommonToDoList
     */
    public static CommonToDoList create(Integer ID, String name, String detail) {
        return new CommonToDoList(ID, name, detail);
    }
}
