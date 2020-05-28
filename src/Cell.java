import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;

public class Cell extends JPanel {
    private int X;
    private int Y;
    private int width;
    private int height;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the rectangle here
        g.drawRect(X, Y, width, height);
    }

}
