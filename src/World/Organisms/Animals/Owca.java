package World.Organisms.Animals;

import ConstValues.Colors;
import World.World;

public class Owca extends Animal {
    public Owca(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 4;
        this.initiative = 4;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.OWCA.getColor();

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }
}
