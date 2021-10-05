import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SecondGameMode extends JPanel{
    public static int xposship = Main.PANEL_SIZE_X / 2 - 25;
    public static int yposship = Main.PANEL_SIZE_Y - 50;
    public static int[] xposAsteroid = new int[1000000];
    public static int[] yposAsteroid = new int[1000000];
    public static int CurrentAsteroid;
    public static int CountDrawAsteroid = 10;
    public static int RotationShip = 0;
    public static double Alpha;

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
        CalculateSpaceShip();
        drawAsteroids(g);
        DrawSpaceShip(g);
        //System.out.println("PAINT COMPONENT");
    }

    public void CalculateSpaceShip() {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();

        int xposmouse = (int) b.getX();
        int yposmouse = (int) b.getY();

        int Opposite = (yposmouse - 500);
        int Adjacent = (xposmouse - 1000);
        double OppositeDouble = Double.valueOf(Opposite);
        double AdjacentDouble = Double.valueOf(Adjacent);
        if (Adjacent >= 0) {
            Alpha = Math.atan(OppositeDouble / AdjacentDouble);
        }
        else {
            Alpha = Math.PI + Math.atan(OppositeDouble / AdjacentDouble);
        }

        System.out.println(Alpha);

        //xposship = xposmouse;
        //yposship = yposmouse;
    }

    public void DrawSpaceShip(Graphics g) {


        

        AffineTransform at = AffineTransform.getTranslateInstance(1000, 200);
        at.rotate(Alpha);
        BufferedImage ShipBufferedImage = LoadImage("images/spaceship-up.png");
        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(ShipBufferedImage, 800, 500, 200, 200, null);
        g2d.drawImage(ShipBufferedImage, at, null);
    }

    BufferedImage LoadImage(String FileName) 
        {
            BufferedImage img = null;

            try{
                img = ImageIO.read(new File(FileName));
            }catch(IOException e){
                
            }
            return img;
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