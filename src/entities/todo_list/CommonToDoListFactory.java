package entities.todo_list;

public class CommonToDoListFactory {
    /**
     * build up a to_do list
     * @param ID the ID
     * @param name the name
     * @param detail the detail
     */
    public static ToDoList create(int ID, String name, String detail){
        return new CommonToDoList(ID,name,detail);
    }
}
