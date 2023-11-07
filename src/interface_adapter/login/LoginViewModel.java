package interface_adapter.login;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel extends ViewModel {
    public static final String LOGIN_BUTTON_LABEL = "Log in";
    public static final String LOGIN_CANCEL_BUTTON_LABEL = "Cancel";
    public static final String LOGIN_SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String LOGIN_USERNAME_LABEL = "Username";
    public static final String LOGIN_PASSWORD_LABEL = "Password";

    private final LoginState loginState = new LoginState();
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public LoginViewModel() {
        super("log in");
    }

    public LoginState getLoginState() {
        return loginState;
    }

    @Override
    public void firePropertyChanged() {
        propertyChangeSupport.firePropertyChange("state", null, loginState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
}
