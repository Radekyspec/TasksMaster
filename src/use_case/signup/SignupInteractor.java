package use_case.signup;

import data_access.signup.SignupUserDataAccessInterface;

public class SignupInteractor implements SignupInputBoundary {
    private final SignupOutputBoundary signupPresenter;
    private final SignupUserDataAccessInterface userDataAccessObject;

    public SignupInteractor(SignupOutputBoundary signupPresenter, SignupUserDataAccessInterface userDataAccessObject) {
        this.signupPresenter = signupPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        // main signup logic here
    }
}
