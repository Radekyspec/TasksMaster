package view;

import javax.swing.*;
import java.awt.*;

public class JLabelWithFont extends JLabel {
    private final int defaultSize = 26;

    public JLabelWithFont() {
        super();
        setFont(new Font("Times New Roman", Font.PLAIN, defaultSize));
    }

    public JLabelWithFont(int style, int size) {
        super();
        setFont(new Font("Times New Roman", style, size));
    }

    public JLabelWithFont(String text) {
        super(text);
        setFont(new Font("Times New Roman", Font.PLAIN, defaultSize));
    }

    public JLabelWithFont(String text, int size) {
        super(text);
        setFont(new Font("Times New Roman", Font.PLAIN, size));
    }

    public JLabelWithFont(String text, int style, int size) {
        super(text);
        setFont(new Font("Times New Roman", style, size));
    }

    public JLabelWithFont(String text, String name, int style, int size) {
        super(text);
        setFont(new Font(name, style, size));
    }
}
