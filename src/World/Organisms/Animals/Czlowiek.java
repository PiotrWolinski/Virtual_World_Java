package World.Organisms.Animals;

import ConstValues.Colors;
import World.World;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Czlowiek extends Animal {
    private int input;
    private int lastInput;
    private boolean ability;
    private int duration;
    private int reset;

    public Czlowiek(final int Y, final int X, World world) {
        super(Y, X, world);
        this.strength = 5;
        this.initiative = 4;
        this.age = 1;
        this.alive = true;
        this.propagated = false;
        this.color = Colors.CZLOWIEK.getColor();

        this.lastInput = 0;
        this.input = 0;
        this.ability = false;
        this.duration = 0;
        this.reset = 0;

        this.setLastX(this.X);
        this.setLastY(this.Y);
    }

    public final int getInput() {
        return this.input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getLastInput() {
        return lastInput;
    }

    public void setLastInput(int lastInput) {
        this.lastInput = lastInput;
    }

    public boolean isAbility() {
        return ability;
    }

    public void setAbility(boolean ability) {
        this.ability = ability;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReset() {
        return reset;
    }

    public void setReset(int reset) {
        this.reset = reset;
    }

    public void Action() {
        Action(this.getInput());
        this.setInput(0);
    }

    private void Action(int input) {
        move(input);

        if (input != 0) {
            this.lastInput = input;
        }

        ability();

        if (!world.checkIfFieldIsEmpty(this.Y, this.X)) {
            world.returnOrganismFrom(this.Y, this.X).Collision(this);
        }
    }

    private void ability() {
        if (this.ability) {

            if (duration > 2) {
                move(this.lastInput);
            } else {
                if (new Random().nextBoolean()) {
                    move(this.lastInput);
                }
            }

            duration--;

            world.getCommentator().commentAbility(duration);

            if (duration == 0) {
                this.ability = false;
                reset = 5;
            }
        } else {
            if (reset > 0) reset--;
        }
    }

    public void activate() {
        if (duration == 0 && reset == 0) {
            this.ability = true;
            duration = 5;
        }
    }

    private void move(int input) {
        switch (input) {
            case KeyEvent.VK_UP: {
                if (this.Y > 0) {
                    this.Y--;
                }
                break;
            }
            case KeyEvent.VK_RIGHT: {
                if (this.X < this.world.getSizeX() - 1) {
                    this.X++;
                }
                break;
            }
            case KeyEvent.VK_DOWN: {
                if (this.Y < this.world.getSizeY() - 1) {
                    this.Y++;
                }
                break;
            }
            case KeyEvent.VK_LEFT: {
                if (this.X > 0) {
                    this.X--;
                }
                break;
            }
        }
    }

    public String save() {
        String out;
        out = this.toString() + " " + X + " " + Y + " " + strength + " " + age + " "
                + lastX + " " + lastY + " " + alive + " " + propagated + " " + ability + " "
                + duration + " " + reset + " " + lastInput + " " + input;

        return out;
    }
}
