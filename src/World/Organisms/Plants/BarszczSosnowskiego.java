package World.Organisms.Plants;

import ConstValues.Colors;
import World.Organisms.Organism;
import World.World;

public class BarszczSosnowskiego extends Plant{
    public BarszczSosnowskiego(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 10;
        this.initiative = 0;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.BARSZ_SOSNOWSKIEGO.getColor();
    }

    public void Action() {

        if (this.Y > 0) {
            if (!this.world.checkIfFieldIsEmpty(this.Y - 1, this.X) &&
                    this.world.returnOrganismFrom(this.Y - 1, this.X).getInitiative() != 0) {
                this.world.returnOrganismFrom(this.Y - 1, this.X).setAlive(false);

                this.world.getCommentator().commentKill(this, this.world.returnOrganismFrom(this.Y - 1, this.X));
            }
        }
        if (this.X < this.world.getSizeX() - 1) {
            if (!this.world.checkIfFieldIsEmpty(this.Y, this.X + 1) &&
                    this.world.returnOrganismFrom(this.Y, this.X + 1).getInitiative() != 0) {
                this.world.returnOrganismFrom(this.Y, this.X + 1).setAlive(false);

                this.world.getCommentator().commentKill(this, this.world.returnOrganismFrom(this.Y, this.X + 1));
            }
        }
        if (this.Y < this.world.getSizeY() - 1) {
            if (!this.world.checkIfFieldIsEmpty(this.Y + 1, this.X) &&
                    this.world.returnOrganismFrom(this.Y + 1, this.X).getInitiative() != 0) {
                this.world.returnOrganismFrom(this.Y + 1, this.X).setAlive(false);

                this.world.getCommentator().commentKill(this, this.world.returnOrganismFrom(this.Y + 1, this.X));
            }
        }
        if (this.X > 0) {
            if (!this.world.checkIfFieldIsEmpty(this.Y, this.X - 1) &&
                    this.world.returnOrganismFrom(this.Y, this.X - 1).getInitiative() != 0) {
                this.world.returnOrganismFrom(this.Y, this.X - 1).setAlive(false);

                this.world.getCommentator().commentKill(this, this.world.returnOrganismFrom(this.Y, this.X - 1));
            }
        }

        this.world.updateField();

        super.Action();
    }

    public void Collision(Organism attacker) {

        attacker.setAlive(false);

        this.world.getCommentator().commentKill(this, attacker);
    }
}
