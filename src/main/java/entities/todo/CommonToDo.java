package entities.todo;

public class CommonToDo implements ToDo {
    private long ID; // No one will pass an id inside, create a unique id once it created
    private String progress;

    private String target;
    private String[] assignedTo;
    // Do we need to make it all final here? Do we need to change it afterward?

    public CommonToDo(long ID, String target, String[] assignedTo, String progress) {
        this.target = target;
        this.assignedTo = assignedTo;
        this.ID = ID;
        this.progress = progress;
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
    public long getID() {
        return this.ID;
    }

    /**
     * Returns the people who assignTo this obj.
     *
     * @return its assignTo[].
     */
    @Override
    public String[] getAssignedTo() {
        return this.assignedTo;
    }

    /**
     * Return if the to_do is finished.
     *
     * @return incomplete when it isn't complete, done when it's complete.
     */
    @Override
    public String getProgress() {
        return progress;
    }

    /**
     * Return [ ] if it's unfinished, and return [x] if it's finished.
     *
     * @return a string that graphically shows finish or not.
     */
    @Override
    public String getCharProgress() {
        if (progress.equals(ToDo.TODO_INCOMPLETE)) {
            return "[ ]";
        } else if (progress.equals(ToDo.TODO_COMPLETE)) {
            return "[x]";
        }
        return null;
    }
}