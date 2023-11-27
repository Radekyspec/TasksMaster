package use_case.signup;

public class SignupOutputData {
    private final String error;
    private final boolean useCaseFailed;

    public SignupOutputData(String error, boolean useCaseFailed) {
        this.error = error;
        this.useCaseFailed = useCaseFailed;
    }

    public String getError() {
        return error;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
