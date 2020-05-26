package World.Organisms.Plants;

public class Trawa extends Plant{
    public Trawa(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
        this.strength = 0;
        this.initiative = 0;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
    }
}
