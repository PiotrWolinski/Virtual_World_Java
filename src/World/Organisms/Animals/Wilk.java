package World.Organisms.Animals;

public class Wilk extends Animal {
    public Wilk(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
        this.strength = 9;
        this.initiative = 5;
        this.age = 1;
        this.alive = true;
        this.propagated = false;

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }
}
