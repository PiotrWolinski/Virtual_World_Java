package World.Organisms.Animals;

import ConstValues.Colors;
import World.Organisms.Organism;
import World.Organisms.Plants.BarszczSosnowskiego;
import World.World;

import java.util.ArrayList;

public class CyberOwca extends Owca{
    public CyberOwca(final int Y, final int X, World world) {
        super(Y, X, world);
        this.color = Colors.CYBEROWCA.getColor();
        this.strength = 11;
    }

    public void Action() {
        if (world.containsBarszcz()) {
            this.age++;
            BarszczSosnowskiego target = checkForNearestBarszcz();

            int difX = Math.abs(this.X - target.getX());
            int difY = Math.abs(this.Y - target.getY());

            if (difX > difY) {
                if (this.X > target.getX()) {
                    this.X--;
                } else {
                    this.X++;
                }
            } else {
                if (this.Y > target.getY()) {
                    this.Y--;
                } else {
                    this.Y++;
                }
            }

            if (!world.checkIfFieldIsEmpty(this.Y, this.X)) {
                world.returnOrganismFrom(this.Y, this.X).Collision(this);
            }
        } else {
            super.Action();
        }
    }

    public BarszczSosnowskiego checkForNearestBarszcz() {
        ArrayList<BarszczSosnowskiego> barszcz = world.returnBarszcz();
        double dist = Double.POSITIVE_INFINITY;
        BarszczSosnowskiego closestBarszcz = new BarszczSosnowskiego(-1, -1, world);
        for (BarszczSosnowskiego plant: barszcz) {
            double tmpDist = Math.sqrt(Math.pow((this.X - plant.getX()), 2) + Math.pow((this.Y - plant.getY()), 2));
            if (tmpDist < dist) {
                dist = tmpDist;
                closestBarszcz = plant;
            }
        }

        return closestBarszcz;
    }

}
