package View;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private final int row;
    private final int column;

    public Cell(final int column, final int row) {
        super(" ");
        this.row = row;
        this.column = column;
        this.setFocusPainted(false);
        this.setBackground(Color.YELLOW.brighter());
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
