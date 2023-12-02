package entities.todo;

public class CommonToDoFactory {
    /**
     * create a CommonToDo class that contains basic information about a To_Do.
     *
     * @param ID         the identification of this To_Do
     * @param target     the aim, or say goal, of this To_Do
     * @param assignedTo people who are assigned to with this to_do.
     * @return a CommonToDo class.
     */
    public static CommonToDo create(Integer ID, String target, String[] assignedTo, String progress) {
        return new CommonToDo(ID, target, assignedTo, progress);
    }

}
