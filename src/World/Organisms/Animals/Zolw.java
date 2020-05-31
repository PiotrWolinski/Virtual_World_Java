package World.Organisms.Animals;

import ConstValues.Colors;
import World.Organisms.Organism;
import World.World;

import java.util.Random;

public class Zolw extends Animal {
    public Zolw(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 2;
        this.initiative = 1;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.ZOLW.getColor();

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }

    public void Action() {

        Random moveOrNot = new Random();

        lastX = X;
        lastY = Y;

        if (moveOrNot.nextInt(4) == 0) {
           super.Action();
        } else {
            this.age++;
        }
    }

    public void Collision(Organism attacker) {
        if (!attacker.getClass().equals(this.getClass())) {
            if (attacker.getStrength() < 5) {
                attacker.setX(attacker.getLastX());
                attacker.setY(attacker.getLastY());

                this.world.getCommentator().turtleDefended(this, attacker);
            } else if (this.getStrength() > attacker.getStrength()) {
                attacker.setAlive(false);

                this.world.getCommentator().commentKill(this, attacker);
            } else {
                this.setAlive(false);

                this.world.getCommentator().commentKill(attacker, this);
            }
        } else {
            makeDescendant(attacker);
        }
    }
}
