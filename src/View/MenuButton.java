package View;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {

    public MenuButton(String text) {
        super(text);
        this.setBackground(Color.lightGray);
        this.setFocusPainted(false);
        this.setLayout(null);
    }
}
