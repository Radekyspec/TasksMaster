package entities.todo;

public class CommonToDo implements ToDo {
    private Integer ID; // No one will pass an id inside, create a unique id once it created
    // Is Integer type proper here when facing large id?
    private String target;
    private String[] assignedTo;
    // Do we need to make it all final here? Do we need to change it afterward?

    public CommonToDo(Integer ID, String target, String[] assignedTo) { // No expectation of id pass in.
        // This is a setter. 
        this.target = target;
        this.assignedTo = assignedTo;
        this.ID = ID;
        // how to check repeated id? by a method inside here.
        // We should have a db that store our data.
        // We store data temporarily in a text file.
    }

    /**
     * Returns target of this obj.
     *
     * @return its target.
     */
    @Override
    public String getTarget() {
        return this.target;
    }

    /**
     * Returns ID of this obj.
     *
     * @return its ID.
     */
    @Override
    public Integer getId() {
        return this.ID;
    }

    /**
     * Returns the people who is assigned to this obj.
     *
     * @return its assginto[].
     */
    @Override
    public String[] getAssignedTo() {
        return this.assignedTo;
    }
}