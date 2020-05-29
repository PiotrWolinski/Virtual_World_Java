package World.Organisms.Plants;

import ConstValues.Colors;

public class WilczeJagody extends Plant {
    public WilczeJagody(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
        this.strength = 99;
        this.initiative = 0;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.WILCZE_JAGODY.getColor();
    }
}
