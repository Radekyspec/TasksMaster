package interface_adapter.login;

public class LoginState {
    private String username;
    private String password;
    private String loginError;

    public LoginState() {
        username = "";
        password = "";
        loginError = null;
    }

    public String getLoginError() {
        return loginError;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
