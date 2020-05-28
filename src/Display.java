import java.awt.*;
import java.awt.color.ColorSpace;
import java.util.HashSet;
import java.util.Vector;
import World.Organisms.*;

import javax.swing.*;

public class Display extends JFrame {

    public void ShowInterface() {
        Screen screen = new Screen();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(screen);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
    }
    
}
