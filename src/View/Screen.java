package View;

import World.World;

import javax.swing.*;
import java.awt.*;

public class Screen {
    private OrganismsList list;
    private boolean running;
    private World world;
    private JFrame frame;

    public Screen(World world) {
        this.running = true;
        this.world = world;
    }

    public void run () {
        if (running) {
            EventQueue.invokeLater(() -> {
                frame = new JFrame("180297 - Piotr Wolinski");
                frame.setLayout(new BorderLayout());

                Field field = new Field(world.getSizeY(), world.getSizeX(), world);
                frame.getContentPane().add(field, BorderLayout.CENTER);

                CommentatorLobby comments = new CommentatorLobby(frame, world);
                frame.getContentPane().add(comments, BorderLayout.EAST);

                Menu menu = new Menu(world, field, frame, this, comments);
                frame.add(menu, BorderLayout.WEST);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1400, 960);
                frame.setVisible(true);

                list = new OrganismsList(world);
            });
        }
    }

    public void stop() {
        this.running = false;
        frame.dispose();
        closeList();
    }

    public void closeList() {
        this.list.close();
    }
}
