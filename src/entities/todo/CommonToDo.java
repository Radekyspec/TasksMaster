package entities.todo;

import java.util.HashMap;
import java.util.Map;

public class CommonToDo implements ToDo{
    private final Integer ID; // No one will pass an id inside, create a unique id once it created
    // Is Integer type proper here when facing large id?
    private String target;
    private String[] assignedTo;
    // Do we need to make it all final here? Do we need to change it afterward?

    public CommonToDo(Integer LastID, String target, String[] assignedTo){ // No expectation of id pass in.
        // This is a setter. 
        this.target = target;
        this.assignedTo = assignedTo;
        this.ID = LastID + 1;
        // how to check repeated id? by a method inside here.
        // We should have a db that store our data.
        // We store data temporarily in a text file.
    }
    
    @Override
    public Map<String, Object> getToDo(){
        Map<String, Object> tdM = new HashMap<>();
        tdM.put("ID", ID);
        tdM.put("target", target);
        tdM.put("assignedTo", assignedTo);
        return tdM;
    }
}