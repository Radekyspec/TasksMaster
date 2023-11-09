package use_case.signup;

public class SignupOutputData {
    private final String username;
    private final String error;
    private final boolean useCaseFailed;

    public SignupOutputData(String username, String error, boolean useCaseFailed) {
        this.username = username;
        this.error = error;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public String getError() {
        return error;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
