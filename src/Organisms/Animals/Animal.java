package Organisms.Animals;

import Organisms.Organism;

import java.util.Random;

class World{};

public abstract class Animal extends Organism {

    public void Action() {
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

            //tutaj kolizja
        }
    }

    public void Collision(Organism attacker) {
        if (!attacker.getClass().equals(attacker.getClass())) {
            
        }
    }
}
