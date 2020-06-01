package View;

import World.World;

import javax.swing.*;
import java.awt.*;

public class Screen {
    private OrganismsList list;

    public Screen(World world) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("180297 - Piotr Wolinski");
            frame.setLayout(new BorderLayout());

            Field field = new Field(world.getSizeY(), world.getSizeX(), world);
            frame.getContentPane().add(field, BorderLayout.CENTER);

            Menu menu = new Menu(world, field, frame, this);
            frame.add(menu, BorderLayout.WEST);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 960);
            frame.setVisible(true);

            list = new OrganismsList(world);
        });
    }

    public void closeList() {
        this.list.close();
    }
}
