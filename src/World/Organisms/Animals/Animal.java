package World.Organisms.Animals;

import World.Organisms.Organism;
import World.World;

import java.util.Random;

public class Animal extends Organism {

    public void Action() {
        this.age++;
        boolean moved = false;
        Random direction = new Random();

        lastX = X;
        lastY = Y;

        while (!moved) {
            int newDirection = direction.nextInt(4) ;
            if (newDirection == 0 && this.Y > 0) {
                this.Y--;
                moved = true;
            } else if (newDirection == 1 /* && this.X < */) {
                this.X++;
                moved = true;
            } else if (newDirection == 2 /* && this.Y <*/ ) {
                this.Y++;
                moved = true;
            } else if (newDirection == 3 && this.X > 0) {
                this.X--;
                moved = true;
            }

            if (!world.CheckIfFieldIsEmpty(this.Y, this.X)) {
                world.ReturnOrganismFrom(this.Y, this.X).Collision(this);
            }
        }
    }

    public void Collision(Organism attacker) {
        if (!this.getClass().equals(attacker.getClass())) {
            if (this.getStrength() <= attacker.getStrength()) {
                this.setAlive(false);
            } else {
                attacker.setAlive(false);
            }
        } else {
            //rozmnazando
        }
    }

    public void Draw() {

    }
}
