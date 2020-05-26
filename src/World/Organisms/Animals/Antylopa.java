package World.Organisms.Animals;

import World.Organisms.Organism;

public class Antylopa extends Animal {
    public Antylopa(final int Y, final int X) {
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

    public void Action() {
        this.age++;
    }

    public void Collision(Organism attacker) {

    }
}
