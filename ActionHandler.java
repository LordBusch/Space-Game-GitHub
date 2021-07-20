import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import org.graalvm.compiler.hotspot.SymbolicSnippetEncoder.HotSpotSubstrateConstantReflectionProvider;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.Graphics;


public class ActionHandler implements ActionListener{
	
	
	public void actionPerformed(ActionEvent e) {

		System.out.println("- Called actionPerformed() -");
		// Test
		// Action handler
		
		DrawPlanet panPlanets = new DrawPlanet();
		
		
		 //TextField & Label for Angle of shot 
		 Main.textFieldAngle = new JTextField();
		 Main.textFieldAngle.setBounds(0, 0, 70, 30);
		 panPlanets.add(Main.textFieldAngle);
/*
		 Main.ButtonAngle = new JButton("Angle");
		 Main.ButtonAngle.setBounds(70, 0, 70, 30);
		 Main.ButtonAngle.addActionListener(this);
		 Main.ButtonAngle.setVisible(true);
		 
		 panPlanets.add(Main.ButtonAngle);
 */
		 //TextField & Label for Speed of shot
		 Main.textFieldSpeed = new JTextField();
		 Main.textFieldSpeed.setBounds(0, 30, 70, 30);
		 panPlanets.add(Main.textFieldSpeed);
		 
		 Main.ButtonSpeed = new JButton("Speed");
		 Main.ButtonSpeed.setBounds(70, 30, 70, 30);
		 Main.ButtonSpeed.addActionListener(this);

		 
		 panPlanets.add(Main.ButtonSpeed);
		 panPlanets.add(Main.TestLabel);
		 
		
		
		if(e.getSource() == Main.button0) {
			System.out.println("Starting");
			// Get panel from Main

			// branchtest

			

			JFrame frame = Main.frame;
		
			

		 
		
			// Add panel new panel object to main frame and remove former obejct
			frame.remove(Main.pan1);
			frame.setVisible(true);
		
			frame.add(panPlanets);
			frame.setVisible(true);

		}
		
		if(e.getSource() == Main.button1) {
			System.out.println("Hallo Button 1!");
		}


		if(e.getSource() == Main.button2) {
			System.out.println("Hallo Button 2!");
		}	
		

        if(e.getSource() == Main.ButtonAngle) {
			//Main.TextForTestLabel = Main.textFieldAngle.getText();
			Main.TextForTestLabel = "Tschüß";
			System.out.println("Tschüß");
			//String InputAngle = Main.textFieldAngle.getText();
            //System.out.println(InputAngle);
            //System.out.println(Main.textFieldAngle.getText());
		}


        if(e.getSource() == Main.ButtonSpeed) {
			String InputSpeed = Main.textFieldSpeed.getText();
			System.out.println(InputSpeed);
            //System.out.println(InputSpeed);
		}

		
		/*
		// Get panel from Main
		JFrame frame = Main.frame;
		
		// Create new panel object
		JPanel pan = new JPanel();
		pan.setLayout(null); // set to x,y coordinates (0,0) is upper left

		 
		
		// Add panel new panel object to main frame and remove former obejct
		frame.remove(Main.pan1);
		frame.setVisible(true);
		
		frame.add(panPlanets);
		frame.setVisible(true);
		*/
	}
}
