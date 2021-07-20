import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Path;

import javax.imageio.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.util.*;



public class DrawPlanet extends JLabel {
	

	protected void paintComponent(Graphics g) {
		int[] xpos = new int[10];
		int[] ypos = new int[10];
		int[] radius = new int[10];
		int[] xship = new int[2];
		int[] yship = new int[2];
		int freeSpace = 100; // Planets must have this minimum distance to other planets and ships
		int freeSpaceBorder = 100;
		int shipSize = 20;
		boolean isColliding;
		int MaxLengthShot = 1000;
		int xPlanetPic = 840;
		int yPlanetPic = 859;
		
		
		
		//Background
		/*
		ImageIcon FrameBackground = new ImageIcon("Space Background 1.gif");
		Image BackgroundImg = FrameBackground.getImage();
		g.drawImage(BackgroundImg, Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y, null);
		*/

		Main.ButtonAngle = new JButton("Angle");
		 Main.ButtonAngle.setBounds(70, 0, 70, 30);
		 Main.ButtonAngle.addActionListener(Main.handler);
		 Main.ButtonAngle.setVisible(true);
		 
		 this.add(Main.ButtonAngle);

		 // Create button1
		 Main.button1 = new JButton("Button 2");
		 Main.button1.setBounds(100, 200, 100, 50);
		 Main.button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 Main.button1.addActionListener(Main.handler);
		 Main.button1.setVisible(true);

		 this.add(Main.button1);
		
		// Draw Ships
		xship[0] = 50;
		xship[1] = Main.PANEL_SIZE_X - 50 - shipSize;
		for (int i = 0; i < 2; i++) {
			yship[i] = (int)(Math.random() * Main.PANEL_SIZE_Y);
			
			g.setColor(Color.black);
			g.fillRect(xship[i], yship[i], 20, 20);
		}

		// Draw planets
		int numberOfPlanets = 10;
		for (int i = 0; i < numberOfPlanets; i++) {
			System.out.format("Hallo Planet %d\n", i);
			
			do {
				// random gives random number 0..1, multiply with dimension
				
				xpos[i] = (int)(freeSpaceBorder + Math.random() * (Main.PANEL_SIZE_X - 2 * freeSpaceBorder));
				ypos[i] = (int)(freeSpaceBorder + Math.random() * (Main.PANEL_SIZE_Y - 2 * freeSpaceBorder));
				radius[i] = (int)(Math.random() * Main.MAX_PLANET_RADIUS);
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
				
			} while (isColliding);
			
			// Random color
			float red = (float)Math.random();
			float green = (float)Math.random();
			float blue = (float)Math.random();
			Color randomColor = new Color(red, green, blue);
			
			// Draw planet 
			//img = ImageIO.read("Space Game Planet.png");
			g.setColor(randomColor);
			g.fillOval(xpos[i] - radius[i], ypos[i] - radius[i], radius[i] * 2, radius[i] * 2);
			
			// Draw Planet Image
			
			
			ImageIcon planetIcon = new ImageIcon("Space Game Planet 2.png");
			Image planetImg = planetIcon.getImage();
			
			
			//g.setClip(xpos[i], ypos[i], radius[i] * 2, radius[i] * 2);
			//g.create(xpos[i], ypos[i], radius[i] * 2, radius[i] * 2);
			//g.drawImage(planetImg, xpos[i] - xPlanetPic / 2, ypos[i] - yPlanetPic / 2, null);
			Image resizedPlanetImg = planetImg.getScaledInstance(radius[i] * 2, radius[i] * 2, java.awt.Image.SCALE_SMOOTH);
			//super.paintComponent(g);


            //BufferedImage iconeNave = resizedPlanetImg;
            //BufferedImage iconeNave = (BufferedImage)planetImg;
			//g.drawImage(iconeNave, xpos[i], ypos[i], null);

            ImageIcon scaledPlanetIcon = new ImageIcon(resizedPlanetImg);

            BufferedImage bi = new BufferedImage(
                scaledPlanetIcon.getIconWidth(),
                scaledPlanetIcon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
            //Graphics g = bi.createGraphics();
            // paint the Icon to the BufferedImage.
            scaledPlanetIcon.paintIcon(null, g, xpos[i] - radius[i], ypos[i] - radius[i]);
            //g.dispose();
    
			//möglicherweise Problem: Panel ist über Image (Image muss auf Panel draufgemalt werden)
			
		}
		//repaint();
		// Shoot with angle and velocity
		int angle = 0;
		int velocity = 0;
		double xvector = 0;
		double yvector = 1;

		// SHoot from position of ship 0
		double xshot = (double)(xship[0] + shipSize / 2);
		double yshot = (double)(yship[0] + shipSize / 2);
		
		g.setColor(Color.red);
		
		// Let shot move
		int count = 0;
		do {
			++count;
			for (int i = 0; i < numberOfPlanets; i++) {
				// Planet pull with 1.0/(distance*diatance)
				double distanceX = (xpos[i] - xshot);
				double distanceY = (ypos[i] - yshot);
				double planetPull = 1.0 / ((distanceX * distanceX) + (distanceY * distanceY));
				
				xvector = xvector + distanceX * planetPull;
				yvector = yvector + distanceY * planetPull;
				
				//System.out.format("Vector %d: %f - %f - %f: %f %f\n", i, distanceX, distanceY, planetPull, xvector, yvector);
			}
			
			// Calculate new position
			xshot = xshot + xvector;
			yshot = yshot + yvector;

            boolean didHitPlanet = false;
            boolean didHitShip0 = false;
            boolean didHitShip1 = false;
			

			// Check planet collision
			for (int i = 0; i < numberOfPlanets; i++) {
				double distanceX = (xpos[i] - xshot);
				double distanceY = (ypos[i] - yshot);
				double distanceCenters = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
                //System.out.format("Collision check Planet %d: distance = %d of %d\n", i, (int)distanceCenters, radius[i]);
				if (distanceCenters < (double)radius[i]) {
					System.out.format("Collision Planet %d.\n", i);
                    didHitPlanet = true;
				}
			}
			
			// Check planet collision
			for (int i = 0; i < 2; i++) {
				double distanceX = (xship[i] - xshot);
				double distanceY = (yship[i] - yshot);
				double distanceCenters = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
				if (distanceCenters < (double)shipSize) {
				//	System.out.format("Collision Ship %d.\n", i);
                    if (i==0) {
                        didHitShip0 = true;
                    }
                    else {
                        didHitShip1 = true;
                    }
				}
			}
	
			// Draw shots position
			g.fillOval((int)(xshot - 1), (int)(yshot - 1), 2, 2);

            if (didHitPlanet) {
                g.fillOval((int)(xshot - 10), (int)(yshot - 10), 20, 20);
                System.out.format("Bad shot!.\n");
                break;
            }
            if (didHitShip0 && false) {
                g.fillOval((int)(xshot - 10), (int)(yshot - 10), 20, 20);
                System.out.format("You shot yourself!.\n");
                break;
            }
            if (didHitShip1) {
                g.fillOval((int)(xshot - 10), (int)(yshot - 10), 20, 20);
                System.out.format("You won!.\n");
                break;
            }		
			
		} while (count < 1000);
	}
	
}

//DEF

//123
