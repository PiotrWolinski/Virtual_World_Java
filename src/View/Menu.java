package View;

import World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

    public Menu(World world, Field field, JFrame frame, Screen screen) {
        setLayout(new GridLayout(5, 1));

        MenuButton nextTurn = new MenuButton("Nastepna tura");
        nextTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.makeTurn();
                field.updateField();
                // komentarze zostana dodane
            }
        });

        MenuButton exit = new MenuButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        MenuButton save = new MenuButton("Zapisz");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.saveGame();
            }
        });

        MenuButton read = new MenuButton("Wczytaj");
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.readSave();
                field.updateField();
                screen.closeList();
            }
        });

        MenuButton humanAbility = new MenuButton("Aktywuj umiejetnosc");
        humanAbility.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.activateAbility();
            }
        });
        this.add(nextTurn);
        this.add(humanAbility);
        this.add(save);
        this.add(read);
        this.add(exit);
    }
}
