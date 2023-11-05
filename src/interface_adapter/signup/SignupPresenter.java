package interface_adapter.signup;

import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

public class SignupPresenter implements SignupOutputBoundary {
    @Override
    public void prepareSuccessView(SignupOutputData signupOutputData) {

    }

    @Override
    public void prepareFailView(SignupOutputData signupOutputData) {

    }
}
