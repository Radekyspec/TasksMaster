package view.signup;

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
    private final SignupViewModel signupViewModel;
    private final SignupController signupController;
    private final JLabel title;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final JButton signUp;
    private final JButton cancel;

    public SignupView(SignupViewModel signupViewModel, SignupController signupController) {
        this.signupViewModel = signupViewModel;
        this.signupController = signupController;
        signupViewModel.addPropertyChangeListener(this);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.SIGNUP_USERNAME_LABEL),
                usernameInputField
        );
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.SIGNUP_PASSWORD_LABEL),
                passwordInputField
        );
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.SIGNUP_REPEAT_PASSWORD_LABEL),
                repeatPasswordInputField
        );

        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState state = signupViewModel.getSignupState();
                        state.setUsername(usernameInputField.getText() + e.getKeyChar());
                        signupViewModel.firePropertyChanged();
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        // Do nothing since done in keyTyped.
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        // Do nothing since done in keyTyped.
                    }
                }
        );
        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState state = signupViewModel.getSignupState();
                        state.setPassword(Arrays.toString(passwordInputField.getPassword()) + e.getKeyChar());
                        signupViewModel.firePropertyChanged();
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        // Do nothing because done in keyTyped.
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        // Do nothing because done in keyTyped.
                    }
                }
        );
        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState state = signupViewModel.getSignupState();
                        state.setRepeatPassword(
                                Arrays.toString(repeatPasswordInputField.getPassword()) + e.getKeyChar()
                        );
                        signupViewModel.firePropertyChanged();
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        // Do nothing because done in keyTyped.
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        // Do nothing because done in keyTyped.
                    }
                }
        );

        JPanel buttons = new JPanel();
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        cancel = new JButton(SignupViewModel.SIGNUP_CANCEL_BUTTON_LABEL);
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(
                e -> {
                    if (e.getSource().equals(signUp)) {
                        SignupState state = signupViewModel.getSignupState();
                        signupController.execute(
                                state.getUsername(),
                                state.getPassword(),
                                state.getRepeatPassword()
                        );
                    }
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
        System.exit(0);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {

        }
        if (state.getPasswordError() != null) {

        }
        if (state.getRepeatPasswordError() != null) {

        }
    }
}
