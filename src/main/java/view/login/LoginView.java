package view.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JButton login;
    private final JButton signUp;
    private final JButton cancel;

    public LoginView(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel,
                     LoginViewModel loginViewModel, LoginController loginController) {
        this.loginViewModel = loginViewModel;
        this.loginController = loginController;
        loginViewModel.addPropertyChangeListener(this);

        JPanel usernameInfo = new JPanel();
        usernameInfo.add(new JLabelWithFont(LoginViewModel.LOGIN_USERNAME_LABEL));
        usernameInfo.add(usernameInputField);
        usernameInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        JPanel passwordInfo = new JPanel();
        passwordInfo.add(new JLabelWithFont(LoginViewModel.LOGIN_PASSWORD_LABEL));
        passwordInfo.add(passwordInputField);
        passwordInputField.setFont(new Font("Times New Roman", Font.PLAIN, 26));

        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        // Do nothing since already done in keyReleased
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        // Do nothing since already done in keyReleased
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        LoginState state = loginViewModel.getLoginState();
                        state.setUsername(usernameInputField.getText());
                        loginViewModel.firePropertyChanged();
                    }
                }
        );
        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        // Do nothing since already done in keyReleased
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        // Do nothing since already done in keyReleased
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        LoginState state = loginViewModel.getLoginState();
                        state.setPassword(String.valueOf(passwordInputField.getPassword()));
                        loginViewModel.firePropertyChanged();
                    }
                }
        );

        JPanel buttons = new JPanel();
        login = new JButtonWithFont(LoginViewModel.LOGIN_BUTTON_LABEL);
        signUp = new JButtonWithFont(LoginViewModel.LOGIN_SIGNUP_BUTTON_LABEL);
        cancel = new JButtonWithFont(LoginViewModel.LOGIN_CANCEL_BUTTON_LABEL);
        buttons.add(login);
        buttons.add(signUp);
        buttons.add(cancel);
        login.addActionListener(this);
        signUp.addActionListener(
                e -> {
                    if (!e.getSource().equals(signUp)) {
                        return;
                    }
                    viewManagerModel.setActiveView(signupViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );
        cancel.addActionListener(
                e -> System.exit(0)
        );

        JLabel title = new JLabelWithFont(LoginViewModel.LOGIN_TITLE_LABEL, Font.BOLD, 32);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createVerticalGlue());
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        LoginState state = loginViewModel.getLoginState();
        loginController.execute(
                state.getUsername(),
                state.getPassword()
        );
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        if (state.getLoginError() != null) {
            JOptionPane.showMessageDialog(this, state.getLoginError());
            state.setLoginError(null);
        }
    }

    public String getViewName() {
        return loginViewModel.getViewName();
    }
}
