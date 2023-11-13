package view.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import view.LabelTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    private final ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;
    private final SignupController signupController;
    private final LoginViewModel loginViewModel;
    private final JLabel title;
    private final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameHint = new JLabel();
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordHint = new JLabel();
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final JLabel repeatPasswordHint = new JLabel();
    private final JButton signUp;
    private final JButton cancel;

    public SignupView(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel,
                      SignupController signupController, LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.signupController = signupController;
        this.loginViewModel = loginViewModel;
        signupViewModel.addPropertyChangeListener(this);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.SIGNUP_USERNAME_LABEL),
                usernameInputField,
                usernameHint
        );
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.SIGNUP_PASSWORD_LABEL),
                passwordInputField,
                passwordHint
        );
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.SIGNUP_REPEAT_PASSWORD_LABEL),
                repeatPasswordInputField,
                repeatPasswordHint
        );

        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        // Do nothing since done in keyReleased.
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        // Do nothing since done in keyReleased.
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        SignupState state = signupViewModel.getSignupState();
                        state.setUsername(usernameInputField.getText());
                        signupViewModel.firePropertyChanged();
                    }
                }
        );
        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        // Do nothing because done in keyReleased.
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        // Do nothing because done in keyReleased.
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        SignupState state = signupViewModel.getSignupState();
                        state.setPassword(Arrays.toString(passwordInputField.getPassword()));
                        signupViewModel.firePropertyChanged();
                    }
                }
        );
        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        // Do nothing because done in keyReleased.
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        // Do nothing because done in keyReleased.
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        SignupState state = signupViewModel.getSignupState();
                        state.setRepeatPassword(Arrays.toString(repeatPasswordInputField.getPassword()));
                        signupViewModel.firePropertyChanged();
                    }
                }
        );

        JPanel buttons = new JPanel();
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        cancel = new JButton(SignupViewModel.SIGNUP_CANCEL_BUTTON_LABEL);
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(
                e -> {
                    if (!e.getSource().equals(cancel)) {
                        return;
                    }
                    viewManagerModel.setActiveView(loginViewModel.getViewName());
                    viewManagerModel.firePropertyChanged();
                }
        );

        title = new JLabel(SignupViewModel.SIGNUP_TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

    public String getViewName() {
        return signupViewModel.getViewName();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getSource().equals(signUp)) {
            return;
        }
        SignupState state = signupViewModel.getSignupState();
        signupController.execute(
                state.getUsername(),
                state.getPassword(),
                state.getRepeatPassword()
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            usernameHint.setText(state.getUsernameError());
        }
        if (state.getPasswordError() != null) {
            passwordHint.setText(state.getPasswordError());
        }
        if (state.getRepeatPasswordError() != null) {
            repeatPasswordHint.setText(state.getRepeatPasswordError());
        }
    }
}
