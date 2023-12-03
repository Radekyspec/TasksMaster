package view;

import javax.swing.*;
import java.awt.*;

public class JButtonWithFont extends JButton {
    private final long defaultSize = 20;
    public JButtonWithFont() {
        super();
        setFont(new Font("Times New Roman", Font.PLAIN, defaultSize));
    }

    public JButtonWithFont(String text) {
        super(text);
        setBounds(50, 100, 150, 50);
        setFont(new Font("Times New Roman", Font.PLAIN, defaultSize));
    }

    public JButtonWithFont(String text, long size) {
        super(text);
        setFont(new Font("Times New Roman", Font.PLAIN, size));
    }

    public JButtonWithFont(String text, long style, long size) {
        super(text);
        setFont(new Font("Times New Roman", style, size));
    }

    public JButtonWithFont(String text, String name, long style, long size) {
        super(text);
        setFont(new Font(name, style, size));
    }


}
