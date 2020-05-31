package World.Organisms.Animals;

import ConstValues.Colors;
import World.Organisms.Organism;
import World.World;

import java.util.Random;

public class Antylopa extends Animal {
    public Antylopa(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 4;
        this.initiative = 4;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.ANTYLOPA.getColor();

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }

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
            } else if (newDirection == 1  && this.X < this.world.getSizeX() - 1) {
                this.X++;
                moved = true;
            } else if (newDirection == 2  && this.Y < this.world.getSizeY() - 1 ) {
                this.Y++;
                moved = true;
            } else if (newDirection == 3 && this.X > 0) {
                this.X--;
                moved = true;
            }
        }

        lastX = X;
        lastY = Y;
        moved = false;

        while (!moved) {
            int newDirection = direction.nextInt(4);
            if (newDirection == 0 && this.Y > 0) {
                this.Y--;
                moved = true;
            } else if (newDirection == 1 && this.X < this.world.getSizeX() - 1) {
                this.X++;
                moved = true;
            } else if (newDirection == 2 && this.Y < this.world.getSizeY() - 1 ) {
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

        boolean run = new Random().nextBoolean();

        if (this.getClass().equals(attacker.getClass())) {
            makeDescendant(attacker);
        } else if (!run) {
            if (this.getStrength() <= attacker.getStrength()) {
                this.setAlive(false);

                this.world.getCommentator().commentKill(attacker, this);
            } else {
                attacker.setAlive(false);

                this.world.getCommentator().commentKill( this, attacker);
            }
        } else {
            boolean moved = false;

            setLastX(X);
            setLastY(Y);

            int moves = 0;
            Random dir = new Random();

            while (!moved && moves != 4) {
                int tmp = dir.nextInt(4);
                if (tmp == 0 && this.Y > 0) {
                    if (this.world.checkIfFieldIsEmpty(this.Y - 1, this.X)) {
                        this.Y--;
                        moved = true;
                    } else {
                        moves++;
                    }
                } else if (tmp == 1 && this.X < this.world.getSizeX() - 1) {
                    if (this.world.checkIfFieldIsEmpty(this.Y, this.X + 1)) {
                        this.X++;
                        moved = true;
                    } else {
                        moves++;
                    }
                } else if (tmp == 2 && this.Y < this.world.getSizeY() - 1) {
                    if (this.world.checkIfFieldIsEmpty(this.Y + 1, this.X)) {
                        this.Y++;
                        moved = true;
                    } else {
                        moves++;
                    }
                } else if (tmp == 3 && this.X > 0) {
                    if (this.world.checkIfFieldIsEmpty(this.Y, this.X - 1)) {
                        this.X--;
                        moved = true;
                    } else {
                        moves++;
                    }
                }
            }

            if (!moved) {
                if (this.getStrength() <= attacker.getStrength()) {
                    this.alive = false;

                    this.world.getCommentator().commentKill(attacker, this);
                } else {
                    attacker.setAlive(false);

                    this.world.getCommentator().commentKill( this, attacker);
                }
            } else {
                this.world.getCommentator().commentAntylopaUciekla(this, attacker, this.getX(), this.getY());
            }
        }
    }
}
