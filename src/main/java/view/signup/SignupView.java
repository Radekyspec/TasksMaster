package view.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import view.JButtonWithFont;
import view.JLabelWithFont;
import view.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    private final SignupViewModel signupViewModel;
    private final SignupController signupController;
    private final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameHlong = new JLabelWithFont();
    private final JTextField emailInputField = new JTextField(15);
    private final JLabel emailHlong = new JLabelWithFont();
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordHlong = new JLabelWithFont();
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final JLabel repeatPasswordHlong = new JLabelWithFont();
    private final JButton signUp;
    private final JButton cancel;

    public SignupView(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel,
                      SignupController signupController, LoginViewModel loginViewModel) {
        this.signupViewModel = signupViewModel;
        this.signupController = signupController;
        signupViewModel.addPropertyChangeListener(this);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabelWithFont(SignupViewModel.SIGNUP_USERNAME_LABEL),
                usernameInputField,
                usernameHint
        );
        LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabelWithFont(SignupViewModel.SIGNUP_EMAIL_LABEL),
                emailInputField,
                emailHint
        );
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabelWithFont(SignupViewModel.SIGNUP_PASSWORD_LABEL),
                passwordInputField,
                passwordHint
        );
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabelWithFont(SignupViewModel.SIGNUP_REPEAT_PASSWORD_LABEL),
                repeatPasswordInputField,
                repeatPasswordHint
        );
        usernameHint.setForeground(Color.RED);
        emailHint.setForeground(Color.RED);
        passwordHint.setForeground(Color.RED);
        repeatPasswordHint.setForeground(Color.RED);

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
        emailInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        SignupState state = signupViewModel.getSignupState();
                        state.setEmail(emailInputField.getText());
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
                        state.setPassword(String.valueOf(passwordInputField.getPassword()));
                        state.setRepeatPassword(String.valueOf(repeatPasswordInputField.getPassword()));
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
                        state.setRepeatPassword(String.valueOf(repeatPasswordInputField.getPassword()));
                        signupViewModel.firePropertyChanged();
                    }
                }
        );

        JPanel buttons = new JPanel();
        signUp = new JButtonWithFont(SignupViewModel.SIGNUP_BUTTON_LABEL);
        cancel = new JButtonWithFont(SignupViewModel.SIGNUP_CANCEL_BUTTON_LABEL);
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

        JLabel title = new JLabelWithFont(SignupViewModel.SIGNUP_TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 20));
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createVerticalGlue());
        this.add(usernameInfo);
        this.add(emailInfo);
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
                state.getEmail(),
                state.getPassword(),
                state.getRepeatPassword()
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            usernameHint.setText(state.getUsernameError());
        } else {
            usernameHint.setText("");
        }
        if (state.getPasswordError() != null) {
            passwordHint.setText(state.getPasswordError());
        } else {
            passwordHint.setText("");
        }
        if (state.getRepeatPasswordError() != null) {
            repeatPasswordHint.setText(state.getRepeatPasswordError());
        } else {
            repeatPasswordHint.setText("");
        }
        if (state.getEmailError() != null) {
            emailHint.setText(state.getEmailError());
        } else {
            emailHint.setText("");
        }
        if (state.getSignupError() != null) {
            JOptionPane.showMessageDialog(this, state.getSignupError());
            state.setSignupError(null);
        }
    }
}
