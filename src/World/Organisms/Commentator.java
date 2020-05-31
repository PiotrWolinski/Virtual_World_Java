package World.Organisms;

import World.Organisms.Animals.Animal;

import java.util.ArrayList;

public class Commentator {
    private final ArrayList<String> comments;

    public Commentator() {
        this.comments = new ArrayList<>();
    }

    public void commentKill(Organism killer, Organism victim) {
        String comment;
        if (victim instanceof Animal) {
            comment = killer.getClass().getName() + " zabil " + victim.getClass().getName()
                    + " na polu " + victim.getX() + " " + victim.getY() + '\n';
        } else {
            comment = killer.getClass().getName() + " zjadl " + victim.getClass().getName()
                    + " na polu " + victim.getX() + " " + victim.getY() + '\n';
        }

        comments.add(comment);
    }

    public void commentSuccPropagation(Organism parent, final int newX, final int newY) {
        String comment;
        if (parent instanceof Animal) {
            comment = parent.getClass().getName() + " ma potomka na polu "
                    + newX + " " + newY + '\n';
        } else {
            comment = parent.getClass().getName() + " zasial potomka na polu "
                    + newX + " " + newY + '\n';
        }

        comments.add(comment);
    }

    public void commentUnsuccPropagation(Organism parent) {
        String comment = parent.getClass().getName() + " nie moze miec potomka na polu "
                    + parent.getX() + " " + parent.getY() + '\n';

        comments.add(comment);
    }

    public void clearComments() {
        comments.clear();
    }

    public String getComments() {
        String answer;
        if (comments.size() > 0) {
            answer = comments.get(0);
            comments.remove(0);
            return answer;
        } else {
            return "Przeczytano wszystkie komentarze\n";
        }
    }

    public void turtleDefended(Organism turtle, Organism attacker) {
        String comment = turtle.getClass().getName() + " odgonil " + attacker.getClass().getName()
                + " na polu " + turtle.getX() + " " + turtle.getY() + '\n';
    }

    public void commentAntylopaUciekla(Organism running, Organism attacker, final int X, final int Y) {
        String comment = running.getClass().getName() + " uciekla od " + attacker.getClass().getName()
                + " na pole " + running.getX() + " " + running.getY() + '\n';
    }
}
