package World;

import java.util.*;

import World.Organisms.*;
import ConstValues.OrganismsEnum;
import World.Organisms.Animals.*;
import World.Organisms.Plants.*;
import View.*;

public class World {
    private int sizeX;
    private int sizeY;
    private int round;
    private Organism[][] field;
    private ArrayList<Organism> animals;
    private ArrayList<Organism> plants;
    private Random generator;
    private Czlowiek czlowiek;
    private Commentator commentator;
    private Screen screen;

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getRound() {
        return round;
    }

    public World(int sizeY, int sizeX) {
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        generator = new Random();
        field = new Organism[sizeY][sizeX];
        animals = new ArrayList<Organism>();
        plants = new ArrayList<Organism>();
        commentator = new Commentator();
        screen = new Screen(this);

        initField();

        addOrganisms();

        round = 1;

        sortAnimals();
        sortPlants();
    }

    public final boolean checkIfFieldIsEmpty(final int Y, final int X) { return field[Y][X] == null; }

    public final Organism returnOrganismFrom(final int Y, final int X) {
        return field[Y][X];
    }

    public final int getFieldStrength(final int Y, final int X) {
        if (this.field[Y][X] != null) {
            return this.field[Y][X].getStrength();
        } else {
            return 0;
        }
    }

    public Commentator getCommentator() {
        return commentator;
    }

    public void addAnimal(String parent, final int newX, final int newY) {
        Organism org = null;

        switch (parent) {
            case "Wilk": {
                org = new Wilk(newY, newX, this);
                break;
            }
            case "Owca": {
                org = new Owca(newY, newX, this);
                break;
            }
            case "Lis": {
                org = new Lis(newY, newX, this);
                break;
            }
            case "Zolw": {
                org = new Zolw(newY, newX, this);
                break;
            }
            case "Antylopa": {
                org = new Antylopa(newY, newX, this);
                break;
            }
            case "CyberOwca": {
                org = new CyberOwca(newY, newX, this);
                break;
            }
        }

        if (org != null) {
            org.setPropagated(true);
            animals.add(org);
            sortAnimals();
        }
    }

    public void addPlant(String parent, final int newX, final int newY) {
        Organism org = null;

        switch (parent) {
            case "Trawa": {
                org = new Trawa(newY, newX, this);
                break;
            }
            case "Mlecz": {
                org = new Mlecz(newY, newX, this);
                break;
            }
            case "Guarana": {
                org = new Guarana(newY, newX, this);
                break;
            }
            case "WilczeJagody": {
                org = new WilczeJagody(newY, newX, this);
                break;
            }
            case "BarszczSosnowskiego": {
                org = new BarszczSosnowskiego(newY, newX, this);
                break;
            }
        }

        if (org != null) {
            org.setPropagated(true);
            plants.add(org);
            sortPlants();
        }
    }

    public void updateField() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                field[i][j] = null;
            }
        }

        for (Organism animal : animals) {
            if (animal.isAlive()) {
                field[animal.getY()][animal.getX()] = animal;
            }
        }

        for (Organism plant : plants) {
            if (plant.isAlive()) {
                field[plant.getY()][plant.getX()] = plant;
            }
        }
    }

    public void makeTurn() {
        sortPlants();
        sortAnimals();

        for (int i = 0 ; i < animals.size() ; i++) {
            animals.get(i).Action();

            deleteDead();
            animals.trimToSize();

            updateField();
        }

        for (int i = 0 ; i < plants.size() ; i++) {
            plants.get(i).Action();

            deleteDead();
            plants.trimToSize();

            updateField();
        }

        resetPropagated();
    }

    public void saveGame() {

    }

    public void readSave() {

    }

    private void initField() {
        this.field = new Organism[sizeY][sizeX];
    }

    private void sortAnimals() {
        if (animals.size() > 0) {
            for (int i=0 ; i < animals.size() - 1 ; i++ ) {
                for (int j = 0 ; j < animals.size() - i - 1 ; j++) {
                    if (animals.get(j).getInitiative()  < animals.get(j + 1).getInitiative()) {
                        Collections.swap(animals, j, j + 1);
                    } else if (animals.get(j).getInitiative()  == animals.get(j + 1).getInitiative() &&
                            animals.get(j).getAge()  < animals.get(j + 1).getAge())    {
                        Collections.swap(animals, j, j + 1);
                    }
                }
            }
        }
    }

    private void sortPlants() {
        if (plants.size() > 0) {
            for (int i = 0 ; i < plants.size() - 1 ; i++) {
                for (int j = 0 ; j < plants.size() - i - 1; j++) {
                    if (plants.get(j).getAge() < plants.get(j + 1).getAge()) {
                        Collections.swap(plants, j, j + 1);
                    }
                }
            }
        }
    }

    private void addOrganisms() {
        for (int i = 0 ; i < this.sizeY ; i++) {
            for (int j = 0 ; j < this.sizeX ; j++) {
                if (field[i][j] != null) continue;
                if (generator.nextInt(100) < 20) {
                    switch(generator.nextInt(OrganismsEnum.SUMA_ORGANIZMOW.getId())) {
                        case 0:
                        {
                            field[i][j] = new Wilk(i, j, this);
                            animals.add(field[i][j]);
                            break;
                        }
                        case 1:
                        {
                            field[i][j] = new Owca(i, j, this);
                            animals.add(field[i][j]);
                            break;
                        }
                        case 2:
                        {
                            field[i][j] = new Lis(i, j, this);
                            animals.add(field[i][j]);
                            break;
                        }
                        case 3:
                        {
                            field[i][j] = new Zolw(i, j, this);
                            animals.add(field[i][j]);
                            break;
                        }
                        case 4:
                        {
                            field[i][j] = new Antylopa(i, j, this);
                            animals.add(field[i][j]);
                            break;
                        }
                        case 5:
                        {
                            field[i][j] = new CyberOwca(i, j, this);
                            animals.add(field[i][j]);
                            break;
                        }
                        case 6:
                        {
                            field[i][j] = new Trawa(i, j, this);
                            plants.add(field[i][j]);
                            break;
                        }
                        case 7:
                        {
                            field[i][j] = new Mlecz(i, j, this);
                            plants.add(field[i][j]);
                            break;
                        }
                        case 8:
                        {
                            field[i][j] = new Guarana(i, j, this);
                            plants.add(field[i][j]);
                            break;
                        }
                        case 9:
                        {
                            field[i][j] = new WilczeJagody(i, j, this);
                            plants.add(field[i][j]);
                            break;
                        }
                        case 10:
                        {
                            field[i][j] = new BarszczSosnowskiego(i, j, this);
                            plants.add(field[i][j]);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void deleteDead() {
        for (int i = 0; i < animals.size(); i++) {
            if (!animals.get(i).isAlive()) {
                field[animals.get(i).getY()][animals.get(i).getX()] = null;
                animals.remove(animals.get(i));
            }
        }

        for (int i = 0; i < plants.size(); i++) {
            if (!plants.get(i).isAlive()) {
                field[plants.get(i).getY()][plants.get(i).getX()] = null;
                plants.remove(plants.get(i));
            }
        }
    }

    private void resetPropagated() {
        for (int i = 0 ; i < animals.size(); i++) {
            animals.get(i).setPropagated(false);
        }

        for (int i = 0 ; i < plants.size(); i++) {
            plants.get(i).setPropagated(false);
        }
    }

    private void nextTurn() {
        round++;
    }

    private void clearData() {
        animals.clear();
        animals = null;

        plants.clear();
        plants = null;

        field = null;
    }

}
