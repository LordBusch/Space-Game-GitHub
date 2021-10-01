import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;
import java.awt.*;

public class GameModes extends JPanel{

    public static boolean GameModesActive;
    GameModes() {
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setSize(Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y);
    }

    public void paintComponent(Graphics g) {
        this.thumbnailpics(g);
    }

    public void thumbnailpics(Graphics g) {
        if (GameModesActive) {
            //thumbnail pic game mode 1

            ImageIcon picGameModeOne = new ImageIcon("images/Thumbnail Game Mode 1.png");
            Image picGameModeOneImage = picGameModeOne.getImage();
            Image resizedpicGameModeOne = picGameModeOneImage.getScaledInstance(639, 360, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledpicGameModeOne = new ImageIcon(resizedpicGameModeOne);
            BufferedImage bi = new BufferedImage(
            scaledpicGameModeOne.getIconWidth(),
            scaledpicGameModeOne.getIconHeight(),
            BufferedImage.TYPE_INT_RGB);

            scaledpicGameModeOne.paintIcon(null, g, Main.PANEL_SIZE_X / 20 + 300, 100);

            g.drawRect(Main.PANEL_SIZE_X / 20 + 300, 100, 641, 362);
        }
    }

}
