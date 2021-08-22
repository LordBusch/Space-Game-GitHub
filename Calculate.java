import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;

public class Calculate extends JLabel {

	public static int[] xpos = new int[10];
	public static int[] ypos = new int[10];
	public static int[] radius = new int[10];
	public static int[] xship = new int[2];
	public static int[] yship = new int[2];
	public static int freeSpace = 100; // Planets must have this minimum distance to other planets and ships
	public static int freeSpaceBorder = 100;
	public static int shipSize = 20;
	public static boolean isColliding;
	public static int MaxLengthShotSuper = 1500;
	public static int MaxLengthShot = 1500;
	public static int xPlanetPic = 840;
	public static int yPlanetPic = 859;
	public static double xshot;
	public static double yshot;
	public static int numberOfPlanets;
	public static int[] shot_xpos = new int[MaxLengthShot];
	public static int[] shot_ypos = new int[MaxLengthShot];
	public static int CountTillColision;
	public static int SizeShotCircle = 2;
	public static int PositionCorrectionShot = 1;
	public static long DelayDrawShot = 100;
	public static boolean didHitPlanet = false;
    public static boolean didHitShip0 = false;
    public static boolean didHitShip1 = false;
	public static int SizeExplosionPic_X = 100;
	public static int SizeExplosionPic_Y = 100;
	public static double angle;
	public static double velocity;

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
		this.DrawPlanets(g);
		this.DrawShip(g);
		if(Main.Shoot) {
			this.DrawShot(g);
			this.DrawExplosion(g);
			
			Main.Shoot = false;
		}
	}

	public void CalculateShip() {
		xship[0] = 50;
		xship[1] = Main.PANEL_SIZE_X - 50 - shipSize;
		for (int i = 0; i < 2; i++) {
			yship[i] = (int)(Math.random() * Main.PANEL_SIZE_Y / 2 + Main.PANEL_SIZE_Y / 4);
		}
		
	}
	

	public void DrawShip(Graphics g) {
		for (int i = 0; i < 2; i++) {
			g.setColor(Color.red);
			g.fillRect(xship[i], yship[i], 20, 20);
		}
	}



	public void CalculatePlanets() {
		
		//Background
		/*
		ImageIcon FrameBackground = new ImageIcon("Space Background 1.gif");
		Image BackgroundImg = FrameBackground.getImage();
		g.drawImage(BackgroundImg, Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y, null);
		*/

		

		 
		/*
		// Draw Ships
		xship[0] = 50;
		xship[1] = Main.PANEL_SIZE_X - 50 - shipSize;
		for (int i = 0; i < 2; i++) {
			yship[i] = (int)(Math.random() * Main.PANEL_SIZE_Y);
			
			g.setColor(Color.black);
			g.fillRect(xship[i], yship[i], 20, 20);
		}
		*/

		// Draw planets
		for (int i = 0; i < numberOfPlanets; i++) {
			System.out.format("Hallo Planet %d\n", i);
			
			do {
				// random gives random number 0..1, multiply with dimension
				
				xpos[i] = (int)(freeSpaceBorder + Math.random() * (Main.PANEL_SIZE_X - 2 * freeSpaceBorder));
				ypos[i] = (int)(freeSpaceBorder + Math.random() * (Main.PANEL_SIZE_Y - 2 * freeSpaceBorder));
				radius[i] = (int)(Math.random() * (Main.MAX_PLANET_RADIUS - Main.MIN_PLANET_RADIUS) + Main.MIN_PLANET_RADIUS);
				/*
				xpos[i] = (int)(Math.random() * Main.PANEL_SIZE_X);
				ypos[i] = (int)(Math.random() * Main.PANEL_SIZE_Y);
				radius[i] = (int)(Math.random() * Main.MAX_PLANET_RADIUS);
				*/
				// Check if planets collide
				isColliding = false;
				for (int j = 0; j < i; j++) {
					int distanceX = (xpos[i] - xpos[j]);
					int distanceY = (ypos[i] - ypos[j]);
					int distanceCenters = (int)(Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)));
					//make distance between edge of frame and planet
					/*
					if (xpos[i] + radius[i] > 1920 - freeSpaceBorder | xpos[i] - radius[i] < 0 + freeSpaceBorder | xpos[j] + radius[j] > 1920 - freeSpaceBorder | xpos[j] - radius[j] < 0 + freeSpaceBorder) {
						isColliding = true;
					}
					if (ypos[i] + radius[i] > 1080 - freeSpaceBorder | ypos[i] - radius[i] < 0 + freeSpaceBorder | ypos[j] + radius[j] > 1080 - freeSpaceBorder | ypos[j] - radius[j] < 0 + freeSpaceBorder) {
						isColliding = true;
					}
					*/
					if (distanceCenters < radius[i] + radius[j] + freeSpace ) {
						isColliding = true;
					}
					/*
					System.out.format("Planet %d (%d): %d (%d) - %d (%d) = %d (%d %d) %s\n", 
							i, j, xpos[i], xpos[j], ypos[i], ypos[j], distanceCenters, radius[i], radius[j], isColliding ? "yes" : "no");
							*/
				}
				for (int j = 0; j < 2; j++) {
					int distanceX = (xpos[i] - xship[j]);
					int distanceY = (ypos[i] - yship[j]);
					int distanceCenters = (int)(Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)));
					if (distanceCenters < freeSpace) {
						isColliding = true;
						
					}
					/*
					System.out.format("Ship %d (%d): %d (%d) - %d (%d) = %d (%d %d) %s\n", 
							i, j, xpos[i], xpos[j], ypos[i], ypos[j], distanceCenters, radius[i], radius[j], isColliding ? "yes" : "no");
							*/
				}
				
			} while (isColliding == true);
			
			
			
		}
		
	}

	public void DrawPlanets(Graphics g) {

		//Draw Planet with random color
		/*
		float red = (float)Math.random();
		float green = (float)Math.random();
		float blue = (float)Math.random();
		Color randomColor = new Color(red, green, blue);
	
		g.setColor(randomColor);
		g.fillOval(xpos[i] - radius[i], ypos[i] - radius[i], radius[i] * 2, radius[i] * 2);
		*/

		for (int i = 0; i < Calculate.numberOfPlanets; i++) {
		
			// Draw Planet Image
			ImageIcon planetIcon = new ImageIcon("Space Game Planet 2.png");
			Image planetImg = planetIcon.getImage();

			Image resizedPlanetImg = planetImg.getScaledInstance(Calculate.radius[i] * 2, Calculate.radius[i] * 2, java.awt.Image.SCALE_SMOOTH);

			ImageIcon scaledPlanetIcon = new ImageIcon(resizedPlanetImg);

			BufferedImage bi = new BufferedImage(
			scaledPlanetIcon.getIconWidth(),
			scaledPlanetIcon.getIconHeight(),
			BufferedImage.TYPE_INT_RGB);
		
			// paint the Icon to the BufferedImage.
			scaledPlanetIcon.paintIcon(null, g, Calculate.xpos[i] - Calculate.radius[i], Calculate.ypos[i] - Calculate.radius[i]);
		
		}
	}




	public void CalculateShot() {
		MaxLengthShot = MaxLengthShotSuper;
		CountTillColision = MaxLengthShot;
		SizeShotCircle = 2;
		PositionCorrectionShot = 1;
		didHitPlanet = false;
		didHitShip0 = false;
		didHitShip1 = false;

		// Shoot with angle and velocity
		angle = Double.parseDouble(Main.InputAnglePlayer1);
		velocity = Double.parseDouble(Main.InputSpeedPlayer1);
		

		//desto höher x/y-vector, desto höher Abstände zwischen Punkten
		double xvector = velocity * Math.cos( angle / 180 * Math.PI);
		double yvector = velocity * Math.sin(-angle / 180 * Math.PI);
		System.out.format("Angle: %f Velocity: %f xvector: %f yvector: %f.\n", angle, velocity, xvector, yvector);

		// SHoot from position of ship 0
		xshot = (double)(xship[0] + shipSize / 2);
		yshot = (double)(yship[0] + shipSize / 2);
		
		
		
		// Let shot move
		int count = 0;
		do {
			for (int i = 0; i < numberOfPlanets; i++) {
				// Planet pull with 1.0/(distance*diatance)
				double distanceX = (xpos[i] - xshot);
				double distanceY = (ypos[i] - yshot);
				double planetPull = 5.0 / ((distanceX * distanceX) + (distanceY * distanceY));
				
				xvector = xvector + distanceX * planetPull;
				yvector = yvector + distanceY * planetPull;
				
				//System.out.format("Vector %d: %f - %f - %f: %f %f\n", i, distanceX, distanceY, planetPull, xvector, yvector);
			}
			
			// Calculate new position
			xshot = xshot + xvector;
			yshot = yshot + yvector;
			shot_xpos[count] = (int)xshot;
			shot_ypos[count] = (int)yshot;






			// Check planet collision
			for (int i = 0; i < numberOfPlanets; i++) {
				double distanceX = (xpos[i] - xshot);
				double distanceY = (ypos[i] - yshot);
				double distanceCenters = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
                //System.out.format("Collision check Planet %d: distance = %d of %d\n", i, (int)distanceCenters, radius[i]);
				if (distanceCenters < (double)radius[i]) {
					System.out.format("Collision Planet %d.\n", i);
                    didHitPlanet = true;
					MaxLengthShot = count + 1;
					CountTillColision = count;
				}
			}
			
			// Check ship collision
			for (int i = 0; i < 2; i++) {
				double distanceX = (xship[i] - xshot);
				double distanceY = (yship[i] - yshot);
				double distanceCenters = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
				if (distanceCenters < (double)shipSize && count > 10) {
				System.out.format("Collision Ship %d.\n", i);
                    if (i==0) {
                        didHitShip0 = true;
						MaxLengthShot = count + 1;
						CountTillColision = count;
                    }
                    else {
                        didHitShip1 = true;
						MaxLengthShot = count + 1;
						CountTillColision = count;
                    }
				}
			}

			// increase index
			++count;
		} while (count < MaxLengthShot);
		count = 0;
		System.out.println("CalculateShot ended " + didHitPlanet + " " + didHitShip0 + " " + didHitShip1 + " " + CountTillColision);
	}


	public void DrawShot(Graphics g) {
		/*
			// Explosion GIF
			ImageIcon ExplosionIcon = new ImageIcon("Explosion Icon.png");
			Image ExplosionImg = ExplosionIcon.getImage();

			Image resizedExplosionImg = ExplosionImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

			ImageIcon scaledExplosionIcon = new ImageIcon(resizedExplosionImg);

			BufferedImage bi = new BufferedImage(
			scaledExplosionIcon.getIconWidth(),
			scaledExplosionIcon.getIconHeight(),
			BufferedImage.TYPE_INT_RGB);
		*/
		for (int i = 0; i < MaxLengthShot; i++) {
			if (i==0) System.out.println("DrawShot " + didHitPlanet + " " + didHitShip0 + " " + didHitShip1 + " " + i + " " + CountTillColision);
			if((didHitPlanet | didHitShip0 | didHitShip1) && i == CountTillColision) {
				//SizeShotCircle = 20;
				//PositionCorrectionShot = 10;
				break;
			}
			//wait(10);
			//repaint();
			// Draw shots position
			g.setColor(Color.red);
			g.fillOval((int)(shot_xpos[i] - PositionCorrectionShot), (int)(shot_ypos[i] - PositionCorrectionShot), SizeShotCircle, SizeShotCircle);
		}
	}

	public void DrawExplosion(Graphics g) {
		//Load Explosion PNG
		ImageIcon ExplosionIcon = new ImageIcon("Explosion Image 2.png");
		Image ExplosionImg = ExplosionIcon.getImage();

		Image resizedExplosionImg = ExplosionImg.getScaledInstance(SizeExplosionPic_X, SizeExplosionPic_Y, java.awt.Image.SCALE_SMOOTH);

		ImageIcon scaledExplosionIcon = new ImageIcon(resizedExplosionImg);

		BufferedImage bi = new BufferedImage(
		scaledExplosionIcon.getIconWidth(),
		scaledExplosionIcon.getIconHeight(),
		BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < MaxLengthShot; i++) {
			if((didHitPlanet | didHitShip0 | didHitShip1) && i == CountTillColision) {
				/*
				Image imageExplosion;
				imageExplosion = Toolkit.getDefaultToolkit().createImage("Explosion Image 1.gif");
				g.drawImage(imageExplosion, shot_xpos[i], shot_ypos[i], this);
				*/

				//Draw Explosion Image
				scaledExplosionIcon.paintIcon(null, g, shot_xpos[i] - SizeExplosionPic_X / 2, shot_ypos[i] - SizeExplosionPic_Y / 2);
				System.out.println("Drew Explosion");
			}
			//Show Explosion if shot hasn´t hit anything
			if(didHitPlanet == false && didHitShip0 == false && didHitShip1 == false && i == MaxLengthShotSuper - 1) {
				scaledExplosionIcon.paintIcon(null, g, shot_xpos[i] - SizeExplosionPic_X / 2, shot_ypos[i] - SizeExplosionPic_Y / 2);
			}
		}
	}
	
	
}