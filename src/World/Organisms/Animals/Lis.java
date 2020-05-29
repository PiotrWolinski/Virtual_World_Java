package World.Organisms.Animals;

import ConstValues.Colors;

public class Lis extends Animal {
    public Lis(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
        this.strength = 4;
        this.initiative = 3;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.LIS.getColor();

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }

    public void Action() {
        this.age++;

    }

    public void Draw() {

    }
}
