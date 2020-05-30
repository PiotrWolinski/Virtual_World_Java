package View;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private int X;
    private int Y;

    public Cell(final int X, final int Y) {
        super(" ");
        this.X = X;
        this.Y = Y;
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        //this.setText(" ");
        this.setBackground(Color.YELLOW.brighter());
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public int getY() {
        return Y;
    }
}
