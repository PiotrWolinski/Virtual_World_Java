package World.Organisms.Animals;

import World.Organisms.Organism;
import World.World;

import java.util.Random;

public class Animal extends Organism {

    public Animal(final int Y, final int X, World world) {
        this.Y = Y;
        this.X = X;
        this.world = world;
    }

    public void Action() {
        this.age++;
        boolean moved = false;
        Random direction = new Random();

        lastX = X;
        lastY = Y;

        while (!moved) {
            int newDirection = direction.nextInt(4);
            if (newDirection == 0 && this.Y > 0) {
                this.Y--;
                moved = true;
            } else if (newDirection == 1 && this.X < this.world.getSizeX() - 1) {
                this.X++;
                moved = true;
            } else if (newDirection == 2 && this.Y < this.world.getSizeY() - 1  ) {
                this.Y++;
                moved = true;
            } else if (newDirection == 3 && this.X > 0) {
                this.X--;
                moved = true;
            }
        }

        if (!world.checkIfFieldIsEmpty(this.Y, this.X)) {
            world.returnOrganismFrom(this.Y, this.X).Collision(this);
        }
    }

    public void Collision(Organism attacker) {
        if (!attacker.getClass().equals(this.getClass())) {
            if (this.getStrength() <= attacker.getStrength()) {
                this.setAlive(false);

                this.world.getCommentator().commentKill(attacker, this);
            } else {
                attacker.setAlive(false);

                this.world.getCommentator().commentKill( this, attacker);
            }
        } else {
            makeDescendant(attacker);
        }
    }

    public void makeDescendant(Organism org) {
        if (!this.propagated && !org.isPropagated() && this.getAge() > 5 && org.getAge() > 5) {
            boolean done = false;

            int newX = this.X;
            int newY = this.Y;

            if (this.Y > 0 && this.world.checkIfFieldIsEmpty(this.Y - 1, this.X)) {
                newY--;
                done = true;
            } else if (this.X < this.world.getSizeX() - 1 && this.world.checkIfFieldIsEmpty(this.Y, this.X + 1)) {
                newX++;
                done = true;
            } else if (this.Y < this.world.getSizeY() - 1 && this.world.checkIfFieldIsEmpty(this.Y + 1, this.X)) {
                newY++;
                done = true;
            } else if (this.X > 0 && this.world.checkIfFieldIsEmpty(this.Y, this.X - 1)) {
                newX--;
                done = true;
            }

            if (done) {
                this.world.addAnimal(this.getClass().getName(), newX, newY);

                this.world.getCommentator().commentSuccPropagation(this, newX, newY);

            } else {
                this.world.getCommentator().commentUnsuccPropagation(this);
            }

            this.setPropagated(true);
            org.setPropagated(true);
        } else {
            this.world.getCommentator().commentUnsuccPropagation(this);
        }
    }

    public void Draw() {

    }
}
