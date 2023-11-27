package use_case.signup;

import data_access.signup.SignupUserDataAccessInterface;
import entities.user.CommonUserFactory;
import entities.user.User;

import java.time.LocalDateTime;

public class SignupInteractor implements SignupInputBoundary {
    private final SignupOutputBoundary signupPresenter;
    private final SignupUserDataAccessInterface userDataAccessObject;

    public SignupInteractor(SignupOutputBoundary signupPresenter, SignupUserDataAccessInterface userDataAccessObject) {
        this.signupPresenter = signupPresenter;
        this.userDataAccessObject = userDataAccessObject;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.exists(signupInputData.getUsername())) {
            SignupOutputData outputData = new SignupOutputData(
                    "Username already exists.",
                    true
            );
            signupPresenter.prepareFailView(outputData);
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            SignupOutputData outputData = new SignupOutputData(
                    "Password don't match.",
                    true
            );
            signupPresenter.prepareFailView(outputData);
        } else {
            LocalDateTime now = LocalDateTime.now();
            User user = CommonUserFactory.create(
                    (int) System.currentTimeMillis() / 1000,
                    signupInputData.getUsername(),
                    signupInputData.getPassword(),
                    now,
                    signupInputData.getEmail());
            userDataAccessObject.save(user);
            SignupOutputData outputData = new SignupOutputData(
                    "",
                    false
            );
            signupPresenter.prepareSuccessView(outputData);
        }
    }
}
