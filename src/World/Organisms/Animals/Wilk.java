package World.Organisms.Animals;

import ConstValues.Colors;
import World.World;

public class Wilk extends Animal {
    public Wilk(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 9;
        this.initiative = 5;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.WILK.getColor();

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }
}
