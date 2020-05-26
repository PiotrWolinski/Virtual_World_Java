import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import Organisms.*;

import javax.swing.*;

public class World {
    private int sizeX;
    private int sizeY;
    private int round;
    private Organism[][] field;
    private Set<Organism> animals;
    private Set<Organism> plants;

    public World(int sizeY, int sizeX) {
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        field = new Organism[sizeY][sizeX];
        animals = new HashSet<>();
        plants = new HashSet<>();
    }

    public boolean CheckIfFieldIsEmpty(final int Y, final int X) {
        if (field[Y][X] == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Print() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new GridLayout(1,1,0,0));
        frame.setSize(800, 600);

        frame.setVisible(true);
    }


}
