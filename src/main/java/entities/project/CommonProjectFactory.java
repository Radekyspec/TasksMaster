package entities.project;

public class CommonProjectFactory {
    /**
     * Create a CommonProject object.
     * @param ID the ID of the project
     * @param name the name of the project
     * @param description the description of the project
     */
    public static CommonProject create(int ID, String name, String description){
        return new CommonProject(ID, name, description);
    }
}
