package use_case.project.add;

import entities.user.User;

public class AddProjectInputData {
    private final User user;
    private final String name;
    private final String description;

    public AddProjectInputData(User user, String name, String description) {
        this.user = user;
        this.name = name;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
