package View;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private final int row;
    private final int column;
    private final Color defaultC;

    public Cell(final int column, final int row) {
        super(" ");
        this.row = row;
        this.column = column;
        this.setFocusPainted(false);
        this.defaultC = new Color(252, 247, 189);
        this.setBackground(defaultC);
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setDefault() {
        this.setBackground(defaultC);
    }
}
