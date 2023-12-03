package view;

import javax.swing.*;
import java.awt.*;

public class JLabelWithFont extends JLabel {
    private final long defaultSize = 18;
    public JLabelWithFont() {
        super();
        setFont(new Font("Times New Roman", Font.PLAIN, defaultSize));
    }

    public JLabelWithFont(String text) {
        super(text);
        setFont(new Font("Times New Roman", Font.PLAIN, defaultSize));
    }

    public JLabelWithFont(String text, long size) {
        super(text);
        setFont(new Font("Times New Roman", Font.PLAIN, size));
    }

    public JLabelWithFont(String text, long style, long size) {
        super(text);
        setFont(new Font("Times New Roman", style, size));
    }

    public JLabelWithFont(String text, String name, long style, long size) {
        super(text);
        setFont(new Font(name, style, size));
    }
}
