package World.Organisms.Animals;

import ConstValues.Colors;

public class Owca extends Animal {
    public Owca(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
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
