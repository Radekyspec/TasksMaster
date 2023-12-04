package app;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

class MainTest {

    @Test
    void main() {
        Timer timer = new Timer(1000, e -> {
            for (Window window : Window.getWindows()) {
                if (window instanceof JFrame) {
                    window.dispose();
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
        Main.main(new String[]{});
    }
}