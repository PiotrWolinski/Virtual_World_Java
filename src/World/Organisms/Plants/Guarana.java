package World.Organisms.Plants;

import ConstValues.Colors;
import World.Organisms.Organism;
import World.World;

public class Guarana extends Plant {
    public Guarana(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 0;
        this.initiative = 0;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.GUARANA.getColor();
    }

    public void Collision(Organism attacker) {
        if (attacker.getStrength() >= this.getStrength()) {
            this.alive = false;
            attacker.setStrength(attacker.getStrength() + 3);
        }
        else {
            attacker.setAlive(false);
        }
    }
}
