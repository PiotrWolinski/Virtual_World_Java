package World.Organisms.Animals;

public class Owca extends Animal {
    public Owca(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
        this.strength = 4;
        this.initiative = 4;
        this.age = 1;
        this.alive = true;
        this.propagated = false;

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }
}
