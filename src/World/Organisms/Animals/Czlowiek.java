package World.Organisms.Animals;

import ConstValues.Colors;
import World.World;

public class Czlowiek extends Animal {
    private int input;
    private int lastInput;
    private boolean ability;
    private int duration;
    private int reset;

    public Czlowiek(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 5;
        this.initiative = 5;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.WILK.getColor();

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }

    public final int getInput() {
        return this.input;
    }

    public void setInput(int input) {
        this.input = input;
    }
}
