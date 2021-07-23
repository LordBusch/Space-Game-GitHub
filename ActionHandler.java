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
		
		
		
		 
		 
		
		
		if(e.getSource() == Main.button0) {
			System.out.println("Starting");
			// Get panel from Main

			// branchtest
			DrawPlanet panPlanets = new DrawPlanet();
		
			panPlanets.add(Main.ButtonSpeed);
			panPlanets.add(Main.ButtonAngle);
			panPlanets.add(Main.LabelAngle);
			panPlanets.add(Main.LabelSpeed);
			panPlanets.add(Main.textFieldSpeed);
			panPlanets.add(Main.textFieldAngle);
			

			JFrame frame = Main.frame;
		
			

		 
		
			// Add panel new panel object to main frame and remove former obejct
			frame.remove(Main.pan1);
			frame.add(panPlanets);
			frame.setVisible(true);

		}
		
		if(e.getSource() == Main.button1) {
			
		}


		if(e.getSource() == Main.button2) {
			
		}	
		

        if(e.getSource() == Main.ButtonAngle) {
			Main.InputAngle = Main.textFieldAngle.getText();
			Main.LabelAngle.setText(Main.InputAngle);
			Main.LabelAngle.setVisible(true);
            
		}


        if(e.getSource() == Main.ButtonSpeed) {
			Main.InputSpeed = Main.textFieldSpeed.getText();
			Main.LabelSpeed.setText(Main.InputSpeed);
			Main.LabelSpeed.setVisible(true);
		}

	}
}
