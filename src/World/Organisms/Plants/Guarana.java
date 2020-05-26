package World.Organisms.Plants;

import World.Organisms.Organism;

public class Guarana extends Plant {
    public Guarana(final int Y, final int X) {
        this.Y = Y;
        this.X = X;
        this.strength = 0;
        this.initiative = 0;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
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
