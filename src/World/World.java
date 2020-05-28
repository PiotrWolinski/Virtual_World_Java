package World;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.util.HashSet;
import java.util.Vector;
import World.Organisms.*;

import javax.swing.*;

public class World {
    private int sizeX;
    private int sizeY;
    private int round;
    private Organism[][] field;
    private final Vector<Organism> animals;
    private final Vector<Organism> plants;

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getRound() {
        return round;
    }

    public World(int sizeY, int sizeX) {
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        field = new Organism[sizeY][sizeX];
        animals = new Vector<>();
        plants = new Vector<>();
    }

    private void InitPole() {
        this.field = new Organism[sizeY][sizeX];
    }

    public final boolean CheckIfFieldIsEmpty(final int Y, final int X) { return field[Y][X] == null; }

    public final Organism ReturnOrganismFrom(final int Y, final int X) {
        return field[Y][X];
    }

    public final int GetFieldStrength(final int Y, final int X) {
        if (this.field[Y][X] != null) {
            return this.field[Y][X].getStrength();
        } else {
            return 0;
        }
    }

    public void Print() {
        /*JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new GridLayout(1,1,0,0));
        frame.setSize(800, 600);
        frame.setTitle("180297 - Piotr Wolinski");

        JButton button = new JButton("Przycisk");
        frame.add(button);
        frame.setLayout(null);
        button.setBounds(100, 100, 200, 50);

        Box box = new Box(BoxLayout.LINE_AXIS);
        box.setBackground(new Color(128, 128, 255));
        box.setBounds(50, 50, 100, 100);
        frame.add(box);

        frame.setVisible(true);*/

        


    }


}
