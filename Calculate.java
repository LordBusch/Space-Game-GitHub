import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;
import java.awt.*;

public class Calculate extends JLabel {

	public static final int Size_BlackHole_X = 400;
	public static final int Size_BlackHole_Y = 280;
	public static int midBlackHole_X;
	public static int midBlackHole_Y;
	public static int distanceX;
	public static int distanceY;
	public static int MaxPlanets = 10;
	public static int[] xpos = new int[MaxPlanets];
	public static int[] ypos = new int[MaxPlanets];
	public static int[] radius = new int[MaxPlanets];
	public static int[] xship = new int[2];
	public static int[] yship = new int[2];
	public static double[] randomNumber = new double[MaxPlanets];
	public static int xpos_blackhole;
	public static int ypos_blackhole;
	public static int freeSpace = 100; // Planets must have this minimum distance to other planets and ships
	public static int freeSpaceBorder = 100;
	public static int freeSpace_BlackHole = 400;
	public static int shipSize = 20;
	public static boolean isColliding;
	public static int MaxLengthShotSuper = 1500;
	public static int MaxLengthShot = 1500;
	public static double xshot;
	public static double yshot;
	public static int numberOfPlanets = 0;
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
	public static int NumberShip;
	public static double xvector;
	public static double yvector;
	public static String InputPic = "images/Space Game Planet 2.png";

	private static double[] StarLocationX = new double[100];
	private static double[] StarLocationY = new double[100];

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
		System.out.println("DEBUG - paintComponent");
		if (Main.Start) {
			g.setColor(Color.black);
			g.fillRect(0, 0, Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y);
			g.setColor(Color.white);
			for (int i = 0; i < 100; i++) {
				StarLocationX[i] = Math.random() * Main.PANEL_SIZE_X;
				StarLocationY[i] = Math.random() * Main.PANEL_SIZE_Y;
				int StarLocationXInt = (int) Math.round(StarLocationX[i]);
				int StarLocationYInt = (int) Math.round(StarLocationY[i]);
				
				g.fillOval(StarLocationXInt, StarLocationYInt, 2, 2);
			}
			this.DrawPlanets(g);
			this.DrawShip(g);
			//this.DrawBlackHole(g);
			Main.Start = false;
		}
		
		if(Main.Shoot) {
			g.setColor(Color.black);
			g.fillRect(0, 0, Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y);
			this.DrawPlanets(g);
			this.DrawShip(g);
			for (int i = 0; i < 100; i++) {
				int StarLocationXInt = (int) Math.round(StarLocationX[i]);
				int StarLocationYInt = (int) Math.round(StarLocationY[i]);
				g.setColor(Color.white);
				g.fillOval(StarLocationXInt, StarLocationYInt, 2, 2);
			}
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
				//PNG left side
				ImageIcon SpaceShipIconLeft = new ImageIcon("images/spaceship-right.png");
				Image SpaceShipImgLeftImage = SpaceShipIconLeft.getImage();
				Image resizedSpaceShipImgLeft = SpaceShipImgLeftImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				ImageIcon scaledSpaceShipIconLeft = new ImageIcon(resizedSpaceShipImgLeft);
				BufferedImage bi = new BufferedImage(
				scaledSpaceShipIconLeft.getIconWidth(),
				scaledSpaceShipIconLeft.getIconHeight(),
				BufferedImage.TYPE_INT_RGB);
				//PNG right side
				ImageIcon SpaceShipIconRight = new ImageIcon("images/spaceship-left.png");
				Image SpaceShipImgRightImage = SpaceShipIconRight.getImage();
				Image resizedSpaceShipImgRight = SpaceShipImgRightImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
				ImageIcon scaledSpaceShipIconRight = new ImageIcon(resizedSpaceShipImgRight);
				BufferedImage bi2 = new BufferedImage(
				scaledSpaceShipIconRight.getIconWidth(),
				scaledSpaceShipIconRight.getIconHeight(),
				BufferedImage.TYPE_INT_RGB);

			if (i == 0) {
				scaledSpaceShipIconLeft.paintIcon(null, g, xship[i] - 35, yship[i] - 15);
			}
			else {
				scaledSpaceShipIconRight.paintIcon(null, g, xship[i] + 5, yship[i] - 15);
			}
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
			System.out.format("Calculated Planet " + i);
			//System.out.println(randomNumber[i]);
			randomNumber[i] = Math.random();
			System.out.println(randomNumber[i]);
			
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
			
			
			//randomNumber[i] = Math.random();
		}
		
	}

	public void DrawPlanets(Graphics g) {
		

		for (int i = 0; i < Calculate.numberOfPlanets; i++) {
			
			if (Main.StarWarsMode) {
				if (randomNumber[i] < 0.5) {
					InputPic = "images/Endor.png";
				}
				if (randomNumber[i] > 0.5) {
					InputPic = "images/DeathStar2.png";
				}
			}
			if (Main.NormalMode) {
				if (randomNumber[i] < 0.5) {
					InputPic = "images/Space Game Planet 2.png";
				}
				if (randomNumber[i] > 0.5) {
					InputPic = "images/jupiter.png";
				}
			}
			
			
			// Draw Planet Image
			ImageIcon planetIcon = new ImageIcon(InputPic);
			Image planetImg = planetIcon.getImage();

			Image resizedPlanetImg = planetImg.getScaledInstance(Calculate.radius[i] * 2, Calculate.radius[i] * 2, java.awt.Image.SCALE_SMOOTH);

			ImageIcon scaledPlanetIcon = new ImageIcon(resizedPlanetImg);

			BufferedImage bi = new BufferedImage(
			scaledPlanetIcon.getIconWidth(),
			scaledPlanetIcon.getIconHeight(),
			BufferedImage.TYPE_INT_RGB);

			scaledPlanetIcon.paintIcon(null, g, Calculate.xpos[i] - Calculate.radius[i], Calculate.ypos[i] - Calculate.radius[i]);

		}
	}

	public void CalculateBlackHole() {
		//To be implemented
		
	}

	public void DrawBlackHole(Graphics g) {
		ImageIcon BlackHoleIcon = new ImageIcon("images/black hole logo.png");
		Image BlackHoleImg = BlackHoleIcon.getImage();

		Image resizedBlackHoleImg = BlackHoleImg.getScaledInstance(Size_BlackHole_X, Size_BlackHole_Y, java.awt.Image.SCALE_SMOOTH);

		ImageIcon scaledBlackHoleIcon = new ImageIcon(resizedBlackHoleImg);
		BufferedImage bi = new BufferedImage(
		scaledBlackHoleIcon.getIconWidth(),
		scaledBlackHoleIcon.getIconHeight(),
		BufferedImage.TYPE_INT_RGB);

		scaledBlackHoleIcon.paintIcon(null, g, xpos_blackhole - Size_BlackHole_X / 2, ypos_blackhole - Size_BlackHole_Y / 2);
	}




	public void CalculateShot() {
		MaxLengthShot = MaxLengthShotSuper;
		CountTillColision = MaxLengthShot;
		SizeShotCircle = 2;
		PositionCorrectionShot = 1;
		didHitPlanet = false;
		didHitShip0 = false;
		didHitShip1 = false;

		if(Main.activeplayer == 0) {
			// Shoot with angle and velocity
			angle = Double.parseDouble(Main.InputAnglePlayer1);
			velocity = Double.parseDouble(Main.InputSpeedPlayer1);
			xvector = velocity * Math.cos( angle / 180 * Math.PI);
			yvector = velocity * Math.sin(-angle / 180 * Math.PI);
			NumberShip = 0;
		}

		else{
			// Shoot with angle and velocity
			angle = Double.parseDouble(Main.InputAnglePlayer2);
			velocity = Double.parseDouble(Main.InputSpeedPlayer2);
			xvector = -velocity * Math.cos( angle / 180 * Math.PI);
			yvector = velocity * Math.sin(-angle / 180 * Math.PI);
			NumberShip = 1;
		}


		// SHoot from position of ship 0
		xshot = (double)(xship[NumberShip] + shipSize / 2);
		yshot = (double)(yship[NumberShip] + shipSize / 2);
		
		
		
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
							Main.KillCount2++;
							Main.KillCounter2String = "" + Main.KillCount2;
							Main.KillCounterPlayer2.setText(Main.KillCounter2String);
                    }
                    else {
                        didHitShip1 = true;
						MaxLengthShot = count + 1;
						CountTillColision = count;
							Main.KillCount1++;
							Main.KillCounter1String = "" + Main.KillCount1;
							Main.KillCounterPlayer1.setText(Main.KillCounter1String);
						
                    }
				}
			}

			// increase index
			++count;
		} while (count < MaxLengthShot);
		count = 0;
		System.out.println("CalculateShot ended " + didHitPlanet + " " + didHitShip0 + " " + didHitShip1 + " " + CountTillColision);
		if(Main.activeplayer == 0) {
			Main.activeplayer = 1;
		}
		else {
			Main.activeplayer = 0;
		}
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
			
			// Draw shots position
			g.setColor(Color.red);
			g.fillOval((int)(shot_xpos[i] - PositionCorrectionShot), (int)(shot_ypos[i] - PositionCorrectionShot), SizeShotCircle, SizeShotCircle);
			//wait(10);
			//repaint();
		}
	}

	public void DrawExplosion(Graphics g) {
		//Load Explosion PNG
		ImageIcon ExplosionIcon = new ImageIcon("images/Explosion Image 2.png");
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