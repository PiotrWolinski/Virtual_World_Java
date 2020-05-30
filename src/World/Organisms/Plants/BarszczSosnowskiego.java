package World.Organisms.Plants;

import ConstValues.Colors;
import World.Organisms.Organism;
import World.World;

public class BarszczSosnowskiego extends Plant{
    public BarszczSosnowskiego(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 10;
        this.initiative = 0;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.BARSZ_SOSNOWSKIEGO.getColor();
    }

    public void Action() {

    }

    public void Collision(Organism attacker) {

    }
}
