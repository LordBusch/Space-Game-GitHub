import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;
import java.awt.*;

public class SecondGameMode extends JPanel{
    public static int xposship = Main.PANEL_SIZE_X / 2 - 25;
    public static int yposship = Main.PANEL_SIZE_Y - 50;

    SecondGameMode() {
        this.setSize(Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(Color.black);
        this.setOpaque(true);
    }

    public void paintComponent(Graphics g) {
        DrawSpaceShip(g);
        drawAsteroids(g);
    }

    public void DrawSpaceShip(Graphics g) {
        ImageIcon SpaceShipIconUp = new ImageIcon("images/spaceship-up.png");
		Image SpaceShipIconUpImage = SpaceShipIconUp.getImage();
		Image resizedSpaceShipIconUp = SpaceShipIconUpImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaledSpaceShipIconUp = new ImageIcon(resizedSpaceShipIconUp);

        scaledSpaceShipIconUp.paintIcon(null, g, xposship, yposship);
    }

    public void CalculateAsteroids() {
        
    }

    public void drawAsteroids(Graphics g) {

    }

}
