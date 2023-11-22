package interface_adapter.signup;

import interface_adapter.InputChecker;

public class SignupState {
    private String username;
    private String usernameError;
    private String password;
    private String passwordError;
    private String repeatPassword;
    private String repeatPasswordError;

    public SignupState() {
        username = "";
        usernameError = null;
        password = "";
        passwordError = null;
        repeatPassword = "";
        repeatPasswordError = null;
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
}
