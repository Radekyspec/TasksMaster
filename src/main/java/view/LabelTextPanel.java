package view;

import javax.swing.*;
import java.awt.*;

public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField, JLabel textHint) {
        setLayout(new GridLayout(2, 2));
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        textHint.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(textField);
        this.add(label);
        this.add(textHint);
    }
}
