package View;

import World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Field extends JPanel {
    private final int sizeY;
    private final int sizeX;

    private Cell[][] field;
    private World world;

    public Field(final int sizeY, final int sizeX, World world) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        setLayout(new GridLayout(this.sizeY, this.sizeX));
        field = new Cell[this.sizeY][this.sizeX];
        this.world = world;

        for (int i = 0; i < this.sizeY; i++) {
            for (int j = 0; j < this.sizeX; j++) {
                this.field[i][j] = new Cell(i, j);
                if (!this.world.checkIfFieldIsEmpty(i, j)) {
                    this.field[i][j].setBackground(this.world.returnOrganismFrom(i, j).getColor());
                }
                add(field[i][j]);
            }
        }

        InputMap map = getInputMap(WHEN_IN_FOCUSED_WINDOW);

        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,false),1);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,false),2);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0,false),3);
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,false),4);

        ActionMap actions = getActionMap();

        actions.put(1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.setHumanInput(KeyEvent.VK_UP);
            }
        });
        actions.put(2, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.setHumanInput(KeyEvent.VK_RIGHT);
            }
        });
        actions.put(3, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.setHumanInput(KeyEvent.VK_DOWN);
            }
        });
        actions.put(4, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.setHumanInput(KeyEvent.VK_LEFT);
            }
        });

    }

    public void updateField() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (!world.checkIfFieldIsEmpty(i, j)) {
                    field[i][j].setBackground(world.returnOrganismFrom(i, j).getColor());
                } else {
                    field[i][j].setDefault();
                }
            }
        }
    }
}