package View;

import World.World;

import javax.swing.*;
import java.awt.*;

public class Screen {

    public Screen(World world) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("180297 - Piotr Wolinski");
                frame.setLayout(new BorderLayout());

                Field field = new Field(world.getSizeY(), world.getSizeX(), world);
                frame.getContentPane().add(field, BorderLayout.CENTER);

                Menu menu = new Menu(world, field, frame);
                frame.add(menu, BorderLayout.WEST);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1200, 960);
                frame.setVisible(true);
            }
        });
    }

}
