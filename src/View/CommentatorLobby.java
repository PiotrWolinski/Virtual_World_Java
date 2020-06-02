package View;

import World.Organisms.Commentator;
import World.World;

import javax.swing.*;
import java.awt.*;

public class CommentatorLobby extends JPanel {

    private JFrame frame;
    private JTextArea text;
    private World world;

    public CommentatorLobby(JFrame frame, World world) {
        this.frame = frame;
        this.world = world;

        setLayout(new GridLayout(1, 1));
        text = new JTextArea();
        text.setLayout(null);
        text.setColumns(30);
        text.setFont(new Font("Century Gothic",Font.PLAIN, 12));
        add(text);
    }

    public void updateComments() {
        text.setText(" ");
        String[] comments = this.world.getCommentator().getComments();
        for (int i = 0 ; i < comments.length ; i++) {
            text.append(comments[i]);
        }
    }
}
