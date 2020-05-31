package World.Organisms;

import World.World;

import java.awt.*;

public abstract class Organism {
    protected int strength;
    protected int initiative;
    protected int age;
    protected int X;
    protected int Y;
    protected int lastX;
    protected int lastY;
    protected boolean alive;
    protected boolean propagated;
    protected World world;
    protected Color color;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getLastX() {
        return lastX;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isPropagated() {
        return propagated;
    }

    public void setPropagated(boolean propagated) {
        this.propagated = propagated;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public Color getColor() { return color; }

    public int getInitiative() { return initiative; }

    abstract public void Action();

    abstract public void Collision(Organism attacker);

    abstract public void Draw();

    @Override
    public String toString() { return this.getClass().getSimpleName(); }
}
