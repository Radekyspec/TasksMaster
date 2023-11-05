package use_case.signup;

public interface SignupUserDataAccessInterface {
    boolean exists(String username);
}
