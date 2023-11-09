package entities.todo;


public class CommonToDo implements ToDo{
    private final Integer ID; // No one will pass an id inside, create a unique id once it created
    // Is Integer type proper here when facing large id?
    private final Integer LastID; 
    private String target;
    private String[] assignedTo;
    // Do we need to make it all final here? Do we need to change it afterwards? 

    public CommonToDo(Integer LastID, String target, String[] assignedTo){ // No expection of id pass in.
        // This is a setter. 
        this.LastID = LastID;
        this.target = target;
        this.assignedTo = assignedTo;
        this.ID = LastID + 1;
        // how to check repeated id? by a method inside here.
        // We should have a db that store our data.
        // We store data temporaryly in a text file.
    }
    
    @Override
    public getToDo(){
        return [ID, target, assignedTo];
    }
}