package use_case.login;

import entities.user.User;

public class LoginOutputData {
    private final User user;
    private final String error;
    private final boolean useCaseFailed;

    public LoginOutputData(User user, String error, boolean useCaseFailed) {
        this.user = user;
        this.error = error;
        this.useCaseFailed = useCaseFailed;
    }

    public User getUser() {
        return user;
    }

    public String getError() {
        return error;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
