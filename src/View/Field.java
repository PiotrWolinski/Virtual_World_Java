package View;

import World.World;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private final int sizeY;
    private final int sizeX;

    private Cell[][] field;
    private World world;
    private final Color defaultColor;

    public Field(final int sizeY, final int sizeX, World world) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        defaultColor = Color.YELLOW.brighter();
        setLayout(new GridLayout(this.sizeY, this.sizeX));
        field = new Cell[this.sizeY][this.sizeX];
        this.world = world;

        for (int i = 0; i < this.sizeY; i++) {
            for (int j = 0; j < this.sizeX; j++) {
                //kolorwanie pol na podstawie organizmow z planszy
            }
        }
    }

    public void updateField() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (!world.checkIfFieldIsEmpty(i, j)) {
                    field[i][j].setBackground(world.returnOrganismFrom(i, j).getColor());
                } else {
                    field[i][j].setBackground(defaultColor);
                }
            }
        }
    }
}