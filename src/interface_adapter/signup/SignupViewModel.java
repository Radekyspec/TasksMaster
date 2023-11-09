package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SignupViewModel extends ViewModel {
    public static final String SIGNUP_TITLE_LABEL = "Create Your Account";
    public static final String SIGNUP_USERNAME_LABEL = "Username";
    public static final String SIGNUP_PASSWORD_LABEL = "Enter Password";
    public static final String SIGNUP_REPEAT_PASSWORD_LABEL = "Enter Password again";
    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String SIGNUP_CANCEL_BUTTON_LABEL = "Cancel";

    private SignupState signupState = new SignupState();
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public SignupViewModel() {
        super("sign up");
    }

    public void setSignupState(SignupState signupState) {
        this.signupState = signupState;
    }

    public SignupState getSignupState() {
        return signupState;
    }

    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("state", null, signupState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
