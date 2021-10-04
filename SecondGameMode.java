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
    public static int[] xposAsteroid = new int[1000000];
    public static int[] yposAsteroid = new int[1000000];
    public static int CurrentAsteroid;
    public static int CountDrawAsteroid = 10;

    SecondGameMode() {
        this.setSize(Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(Color.black);
        this.setOpaque(true);
    }

    //Create method for delay
	public static void wait(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        CalculateAsteroids();
        drawAsteroids(g);
        DrawSpaceShip(g);
        //System.out.println("PAINT COMPONENT");
    }

    public void DrawSpaceShip(Graphics g) {
        ImageIcon SpaceShipIconUp = new ImageIcon("images/spaceship-up.png");
		Image SpaceShipIconUpImage = SpaceShipIconUp.getImage();
		Image resizedSpaceShipIconUp = SpaceShipIconUpImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaledSpaceShipIconUp = new ImageIcon(resizedSpaceShipIconUp);

        scaledSpaceShipIconUp.paintIcon(null, g, xposship, yposship);
    }

    public void CalculateAsteroids() {
        if (CountDrawAsteroid == 200) {
            xposAsteroid[CurrentAsteroid] = (int)(Math.random() * Main.PANEL_SIZE_X);
            yposAsteroid[CurrentAsteroid] = 0;
            CountDrawAsteroid = 0;
        }
        CountDrawAsteroid++;
        

        //yship[i] = (int)(Math.random() * Main.PANEL_SIZE_Y / 2 + Main.PANEL_SIZE_Y / 4);
    }

    public void drawAsteroids(Graphics g) {
        g.setColor(Color.white);
        /*
        for (int i = 0; i <= CurrentAsteroid; i++) {
            yposAsteroid[i]++;
            g.fillOval(xposAsteroid[i], yposAsteroid[i], 200, 200);
        }
        */
        //draw present asteroids
        for (int i = 0; i <= CurrentAsteroid; i++) {
            yposAsteroid[i]++;
            g.fillOval(xposAsteroid[i], yposAsteroid[i], 200, 200);
        }
        System.out.println(CurrentAsteroid + "CURRENT ASTEROID");
        if (CountDrawAsteroid == 50) {
            CurrentAsteroid++;
        }

        Main.frame.repaint();
    }

}