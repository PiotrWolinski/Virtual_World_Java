package View;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private int X;
    private int Y;
    private final int width;
    private final int height;

    public Cell(Color... color) {
        this.width = 20;
        this.height = 20;
       /* this.X = X;
        this.Y = Y;*/
        this.setPreferredSize(new Dimension(width, height));
//        this.setBounds(width, height);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setFont(new Font("Arial", Font.PLAIN, 4));
        this.setText(" ");

        if (color != null) this.setBackground(color[0]);
    }
}
