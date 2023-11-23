package interface_adapter.signup;

import interface_adapter.InputChecker;

public class SignupState {
    private String username;
    private String usernameError;
    private String email;
    private String emailError;
    private String password;
    private String passwordError;
    private String repeatPassword;
    private String repeatPasswordError;
    private String signupError;

    public SignupState() {
        username = "";
        usernameError = null;
        email = "";
        emailError = null;
        password = "";
        passwordError = null;
        repeatPassword = "";
        repeatPasswordError = null;
        signupError = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        if (InputChecker.containsNonWord(username)) {
            setUsernameError("Username can only contains characters a-z, A-Z, 0-9 and _");
        } else {
            setUsernameError(null);
        }
    }

    public String getUsernameError() {
        return usernameError;
    }

    private void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        if (!InputChecker.containsValidEmail(email)) {
            setEmailError("Must be an valid email");
        } else {
            setEmailError(null);
        }
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        if (!InputChecker.containsCapital(password)) {
            setPasswordError("Password must contains at least one capital letter");
            return;
        } else {
            setPasswordError(null);
        }
        if (!InputChecker.containsLetter(password)) {
            setPasswordError("Password must contains at least one letter");
            return;
        } else {
            setPasswordError(null);
        }
        if (!InputChecker.containsNumber(password)) {
            setPasswordError("Password must contains at least one number");
            return;
        } else {
            setPasswordError(null);
        }
        if (InputChecker.containsWhiteSpace(password)) {
            setPasswordError("Password cannot contains any whitespace");
        } else {
            setPasswordError(null);
        }
    }

    public String getPasswordError() {
        return passwordError;
    }

    private void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
        if (repeatPassword.isEmpty()) {
            return;
        }
        if (!repeatPassword.equals(password)) {
            setRepeatPasswordError("Password did not match");
        } else {
            setRepeatPasswordError(null);
        }
    }

    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    private void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    public String getSignupError() {
        return signupError;
    }

    public void setSignupError(String signupError) {
        this.signupError = signupError;
    }
}
