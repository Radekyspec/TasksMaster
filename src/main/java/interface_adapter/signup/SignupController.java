package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

public class SignupController {
    private final SignupInputBoundary signupInteractor;

    public SignupController(SignupInputBoundary signupInteractor) {
        this.signupInteractor = signupInteractor;
    }

    public void execute(String username, String email, String password, String repeatPassword) {
        SignupInputData signupInputData = new SignupInputData(username, email, password, repeatPassword);
        signupInteractor.execute(signupInputData);
    }
}
