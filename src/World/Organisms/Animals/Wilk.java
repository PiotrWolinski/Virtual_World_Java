package World.Organisms.Animals;

import ConstValues.Colors;

public class Wilk extends Animal {
    public Wilk(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
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
