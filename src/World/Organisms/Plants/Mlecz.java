package World.Organisms.Plants;

public class Mlecz extends Plant {
    public Mlecz(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
        this.strength = 0;
        this.initiative = 0;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
    }

    public void Action() {
        for (int i=0; i < 3; ++i) super.Action();
    }
}
