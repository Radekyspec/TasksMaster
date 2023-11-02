package entities.todo;


public class CommonToDo implements ToDo{
    private Integer ID;
    private String target;
    private String[] assignedTo;

    public CommonToDo(Integer ID){ // 此处应该期望id传入？
        this.ID = ID;
    }

}
