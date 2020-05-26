package World.Organisms.Plants;

import java.util.Random;

import World.Organisms.Organism;

public abstract class Plant extends Organism {

    public void Action() {
        this.age++;
        Random generator = new Random();
        int propagation_chance = generator.nextInt(100);

        if (propagation_chance < 12) {

            int newX = this.X;
            int newY = this.Y;

            int dir = generator.nextInt(4);
            boolean propagated = false;
            int bound = dir;

            do {
                if (dir == 0) {
                    if (this.Y > 0 && this.world.CheckIfFieldIsEmpty(this.Y - 1, this.X)) {									// sprawdzam gore
                        newY--;
                        propagated = true;
                    }
				    else {
                        dir = (++dir) % 4;
                    }
                }
                else if (dir == 1) {
                    if (this.X < this.world.getSizeX() - 1 && this.world.CheckIfFieldIsEmpty(this.Y, this.X + 1)) {		// sprawdzam prawo
                        newX++;
                        propagated = true;
                    }
				    else {
                        dir = (++dir) % 4;
                    }
                }
                else if (dir == 2) {

                    if (this.Y < this.world.getSizeY() - 1 && this.world.CheckIfFieldIsEmpty(this.Y + 1, this.X)) {		// sprawdzam dol
                        newY++;
                        propagated = true;
                    }
				    else {
                        dir = (++dir) % 4;
                    }
                }
                else if (dir == 3) {
                    if (this.X > 0 && this.world.CheckIfFieldIsEmpty(this.Y, this.X - 1)) {                                    // sprawdzam lewo
                        newX--;
                        propagated = true;
                    } else {
                        dir = (++dir) % 4;
                    }

                }
            } while (!propagated && bound != dir);

            if (propagated && !this.propagated) {
                //adding new plant to the field
            }
        }
    }

    public void Collision(Organism attacker) {
        if (attacker.getStrength() >= this.getStrength()) {
            this.alive = false;
        }
	    else {
            attacker.setAlive(false);
        }
    }

    public void Draw() {

    }
}
