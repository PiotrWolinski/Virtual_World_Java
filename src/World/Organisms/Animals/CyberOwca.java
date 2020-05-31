package World.Organisms.Animals;

import ConstValues.Colors;
import World.World;

public class CyberOwca extends Owca{
    public CyberOwca(final int Y, final int X, World world) {
        super(Y, X, world);
        this.color = Colors.CYBEROWCA.getColor();
        this.strength = 11;
    }
}
