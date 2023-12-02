package interface_adapter.project.add;

import entities.user.User;

public class AddProjectState {
    private String name;
    private String description;
    private User user;
    private String addError;

    public String getAddError() {
        return addError;
    }

    public void setAddError(String addError) {
        this.addError = addError;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
