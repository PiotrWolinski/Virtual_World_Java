package View;

import World.World;
import ConstValues.*;

import javax.swing.*;
import java.awt.*;
public class OrganismsList {
    private Cell list[];

    private JFrame frame;
    public OrganismsList(World world) {
        this.list = new Cell[OrganismsEnum.SUMA_ORGANIZMOW.getId()];
        EventQueue.invokeLater(() -> {
            frame = new JFrame("Lista organizmow");
            JPanel list = new JPanel();
            list.setLayout(new GridLayout(OrganismsEnum.SUMA_ORGANIZMOW.getId(), 1));

            String names[] = {"Wilk", "Owca", "Lis", "Zolw", "Antylopa", "CyberOwca", "Trawa", "Mlecz", "Guarana",
                                "WilczeJagody", "BarszczSosnowskiego", "Czlowiek"};

            for (int i = 0; i < OrganismsEnum.SUMA_ORGANIZMOW.getId(); i++ ) {
                this.list[i] = new Cell(-1,-1);
                this.list[i].setText(names[i]);
                this.list[i].setBackground(Colors.values()[i].getColor());
                list.add(this.list[i]);
            }

            frame.add(list);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 700);
            frame.setVisible(true);
        });
    }

    public void close() {
        frame.dispose();
    }
}