package World;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import World.Organisms.*;
import ConstValues.OrganismsEnum;
import World.Organisms.Animals.*;
import World.Organisms.Plants.*;
import View.*;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

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
    private String fileName;

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
        fileName = "save.txt";

        screen.run();

        initField();

        this.czlowiek = new Czlowiek(generator.nextInt(sizeY), generator.nextInt(sizeX), this);
        this.field[this.czlowiek.getY()][this.czlowiek.getX()] = this.czlowiek;
        animals.add(czlowiek);

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

            updateField();
        }

        for (int i = 0 ; i < plants.size() ; i++) {
            plants.get(i).Action();

            deleteDead();

            updateField();
        }

        nextTurn();
        resetPropagated();
    }

    public void saveGame() {
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileWriter printer = new FileWriter(fileName);

            printer.write(sizeY + " " + sizeX + " " + round + '\n');
            printer.write(Integer.toString(animals.size()));
            printer.write("\n");
            for (int i = 0 ; i < animals.size(); i++) {
                printer.write(animals.get(i).save() + '\n');
            }

            printer.write(Integer.toString(plants.size()));
            printer.write("\n");
            for (int i = 0 ; i < plants.size(); i++) {
                printer.write(plants.get(i).save() + '\n');
            }

            printer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readSave() {
        clearData();

        plants = new ArrayList<>();
        animals = new ArrayList<>();

        File input = new File(fileName);

        try {
            Scanner scanner = new Scanner(input);


            String[] mainSplit = scanner.nextLine().split(" ");
            this.sizeY = parseInt(mainSplit[0]);
            this.sizeX = parseInt(mainSplit[1]);
            this.round = parseInt(mainSplit[2]);
            while (scanner.hasNext()) {
                int animals_size = parseInt(scanner.nextLine());

                for (int i = 0; i < animals_size; i++) {
                    String[] split = scanner.nextLine().split(" ");
                    switch (split[0]) {
                        case "Wilk": {
                            animals.add(new Wilk(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "Owca": {
                            animals.add(new Owca(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "Lis": {
                            animals.add(new Lis(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "Zolw": {
                            animals.add(new Zolw(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "Antylopa": {
                            animals.add(new Antylopa(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "CyberOwca": {
                            animals.add(new CyberOwca(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "Czlowiek": {
                            animals.add(new Czlowiek(parseInt(split[1]), parseInt(split[2]), this));
                            this.czlowiek = (Czlowiek) animals.get(i);
                            break;
                        }
                    }
                    read(i, split, animals);
                    if (split[0].equals("Czlowiek")) {
                        this.czlowiek.setAbility(parseBoolean(split[9]));
                        this.czlowiek.setDuration(parseInt(split[10]));
                        this.czlowiek.setReset(parseInt(split[11]));
                        this.czlowiek.setLastInput(parseInt(split[12]));
                        this.czlowiek.setInput(parseInt(split[13]));
                    }
                }

                int plants_size = parseInt(scanner.nextLine());

                for (int i=0; i < plants_size; i++) {
                    String[] split = scanner.nextLine().split(" ");

                    switch (split[0]) {
                        case "Trawa": {
                            plants.add(new Trawa(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "Mlecz": {
                            plants.add(new Mlecz(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "Guarana": {
                            plants.add(new Guarana(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "WilczeJagody": {
                            plants.add(new WilczeJagody(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                        case "BarszczSosnowskiego": {
                            plants.add(new BarszczSosnowskiego(parseInt(split[1]), parseInt(split[2]), this));
                            break;
                        }
                    }
                    read(i, split, plants);
                }
            }
        } catch (FileNotFoundException e) {

        }

            initField();

            sortPlants();
            sortAnimals();

            updateField();

            screen = new Screen(this);
            screen.run();

    }

    private void read(int i, String[] split, ArrayList<Organism> plants) {
        plants.get(i).setStrength(parseInt(split[3]));
        plants.get(i).setAge(parseInt(split[4]));
        plants.get(i).setLastX(parseInt(split[5]));
        plants.get(i).setLastY(parseInt(split[6]));
        plants.get(i).setAlive(parseBoolean(split[7]));
        plants.get(i).setPropagated(parseBoolean(split[8]));
    }

    private void initField() {
        this.field = new Organism[this.sizeY][this.sizeX];
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
        delete(animals);

        delete(plants);
    }

    private void delete(ArrayList<Organism> organisms) {
        for (int i = 0; i < organisms.size(); i++) {
            if (!organisms.get(i).isAlive()) {
                field[organisms.get(i).getY()][organisms.get(i).getX()] = null;
                organisms.remove(organisms.get(i));
            }
        }

        animals.trimToSize();
    }

    private void resetPropagated() {
        for (int i = 0 ; i < animals.size(); i++) {
            animals.get(i).setPropagated(false);
        }

        for (int i = 0 ; i < plants.size(); i++) {
            plants.get(i).setPropagated(false);
        }
    }

    public void setHumanInput(int input) {
        this.czlowiek.setInput(input);
    }

    private void nextTurn() {
        round++;
    }

    public void activateAbility() {
        this.czlowiek.activate();
    }

    private void clearData() {
        animals.clear();
        animals = null;

        plants.clear();
        plants = null;

        screen.stop();
        screen = null;

        field = null;
        sizeX = -1;
        sizeY = -1;
    }

    public boolean containsBarszcz() {
        for (Organism plant: plants) {
            if (plant instanceof BarszczSosnowskiego) {
                return true;
            }
        }
        return false;
    }

    public ArrayList returnBarszcz() {
        ArrayList<BarszczSosnowskiego> barszcz = new ArrayList<>();
        for (Organism plant: plants) {
            if (plant instanceof BarszczSosnowskiego) {
                barszcz.add((BarszczSosnowskiego)plant);
            }
        }
        return barszcz;
    }

}
