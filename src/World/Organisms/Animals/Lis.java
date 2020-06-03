package World.Organisms.Animals;

import ConstValues.Colors;
import World.World;

import java.util.Random;

public class Lis extends Animal {
    public Lis(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 4;
        this.initiative = 7;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.LIS.getColor();

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }

    public void Action() {
        this.age++;
        boolean moved = false;

        setLastX(X);
        setLastY(Y);

        int moves = 0;
        Random dir = new Random();

        while (!moved && moves != 4) {
            int tmp = dir.nextInt(4);
            if (tmp == 0 && this.Y > 0) {
                if (this.world.getFieldStrength(this.Y - 1, this.X) <= this.strength) {
                    this.Y--;
                    moved = true;
                } else {
                    moves++;
                }
            } else if (tmp == 1 && this.X < this.world.getSizeX() - 1) {
                if (this.world.getFieldStrength(this.Y, this.X + 1) <= this.strength) {
                    this.X++;
                    moved = true;
                } else {
                    moves++;
                }
            } else if (tmp == 2 && this.Y < this.world.getSizeY() - 1) {
                if (this.world.getFieldStrength(this.Y + 1, this.X) <= this.strength) {
                    this.Y++;
                    moved = true;
                } else {
                    moves++;
                }
            } else if (tmp == 3 && this.X > 0) {
                if (this.world.getFieldStrength(this.Y, this.X - 1) <= this.strength) {
                    this.X--;
                    moved = true;
                } else {
                    moves++;
                }
            }
        }

        if (!world.checkIfFieldIsEmpty(this.Y, this.X)) {
            world.returnOrganismFrom(this.Y, this.X).Collision(this);
        }
    }
}
