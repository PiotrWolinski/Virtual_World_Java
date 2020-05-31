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
            comment = killer.toString() + " zabil " + victim.toString()
                    + " na polu " + victim.getX() + " " + victim.getY() + '\n';
        } else {
            comment = killer.toString() + " zjadl " + victim.toString()
                    + " na polu " + victim.getX() + " " + victim.getY() + '\n';
        }

        comments.add(comment);
    }

    public void commentSuccPropagation(Organism parent, final int newX, final int newY) {
        String comment;
        if (parent instanceof Animal) {
            comment = parent.toString() + " ma potomka na polu "
                    + newX + " " + newY + '\n';
        } else {
            comment = parent.toString() + " zasial potomka na polu "
                    + newX + " " + newY + '\n';
        }

        comments.add(comment);
    }

    public void commentUnsuccPropagation(Organism parent) {
        String comment = parent.toString() + " nie moze miec potomka na polu "
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
        String comment = turtle.toString() + " odgonil " + attacker.toString()
                + " na polu " + turtle.getX() + " " + turtle.getY() + '\n';
    }

    public void commentAntylopaUciekla(Organism running, Organism attacker, final int X, final int Y) {
        String comment = running.toString() + " uciekla od " + attacker.toString()
                + " na pole " + running.getX() + " " + running.getY() + '\n';
    }
}
