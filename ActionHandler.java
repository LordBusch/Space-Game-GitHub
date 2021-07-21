import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

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
		
		 panPlanets.add(Main.ButtonSpeed);
		 panPlanets.add(Main.ButtonAngle);
		 panPlanets.add(Main.LabelAngle);
		 panPlanets.add(Main.LabelSpeed);
		 panPlanets.add(Main.textFieldSpeed);
		 panPlanets.add(Main.textFieldAngle);
		 
		 
		
		
		if(e.getSource() == Main.button0) {
			System.out.println("Starting");
			// Get panel from Main

			// branchtest

			

			JFrame frame = Main.frame;
		
			

		 
		
			// Add panel new panel object to main frame and remove former obejct
			frame.remove(Main.pan1);
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
			//Main.textFieldAngle.getText();
			//Main.LabelAngle.setText(Main.TextForLabelAngle);
			System.out.println("Tschüß");
			//String InputAngle = Main.textFieldAngle.getText();
            
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
