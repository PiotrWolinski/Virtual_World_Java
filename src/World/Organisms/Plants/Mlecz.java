package World.Organisms.Plants;

import ConstValues.Colors;
import World.World;

public class Mlecz extends Plant {
    public Mlecz(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 0;
        this.initiative = 0;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.MLECZ.getColor();
    }

    public void Action() {
        for (int i=0; i < 3; ++i) {
            super.Action();
            this.world.updateField();
        }
    }
}
