import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.Integer;


public class ActionHandler implements ActionListener{
	
	
	public void actionPerformed(ActionEvent e) {

		System.out.println("- Called actionPerformed() -");
		 
		Calculate panPlanets = new Calculate();
		JFrame frame = Main.frame;
		
		
		if(e.getSource() == Main.button0) {
			System.out.println("Starting");
			Main.Start = true;

			//Convert String to Int (NumberOfPlanets)
			Main.InputCountPlanets = Main.textFieldCountPlanets.getText();
			int  InputNumberOfPlanets = Integer.parseInt(Main.InputCountPlanets);  
			Calculate.numberOfPlanets = InputNumberOfPlanets;

			panPlanets.add(Main.SpeedButtonPlayer1);
			panPlanets.add(Main.SpeedButtonPlayer2);
			panPlanets.add(Main.AngleButtonPlayer1);
			panPlanets.add(Main.AngleButtonPlayer2);
			panPlanets.add(Main.LabelAnglePlayer1);
			panPlanets.add(Main.LabelAnglePlayer2);
			panPlanets.add(Main.LabelSpeedPlayer1);
			panPlanets.add(Main.LabelSpeedPlayer2);
			panPlanets.add(Main.textFieldSpeedPlayer1);
			panPlanets.add(Main.textFieldSpeedPlayer2);
			panPlanets.add(Main.textFieldAnglePlayer1);
			panPlanets.add(Main.textFieldAnglePlayer2);
			panPlanets.add(Main.ShootButtonPlayer1);
			panPlanets.add(Main.ShootButtonPlayer2);

			panPlanets.add(Main.ResetGameButton);
			
			panPlanets.CalculateShip();
			panPlanets.CalculatePlanets();
			

			
		
		 
			// Add panel new panel object to main frame and remove former obejct
			frame.remove(Main.pan1);
			frame.add(panPlanets);
			frame.setVisible(true);
				
			
		}
		

        if(e.getSource() == Main.AngleButtonPlayer1) {
			Main.InputAnglePlayer1 = Main.textFieldAnglePlayer1.getText();
			Main.LabelAnglePlayer1.setText(Main.InputAnglePlayer1);
			Main.LabelAnglePlayer1.setVisible(true);
            
		}

		if(e.getSource() == Main.AngleButtonPlayer2) {
			Main.InputAnglePlayer2 = Main.textFieldAnglePlayer2.getText();
			Main.LabelAnglePlayer2.setText(Main.InputSpeedPlayer2);
			Main.LabelAnglePlayer2.setVisible(true);
            
		}


        if(e.getSource() == Main.SpeedButtonPlayer1) {
			Main.InputSpeedPlayer1 = Main.textFieldSpeedPlayer1.getText();
			Main.LabelSpeedPlayer1.setText(Main.InputSpeedPlayer1);
			Main.LabelSpeedPlayer1.setVisible(true);
		}

		if(e.getSource() == Main.SpeedButtonPlayer2) {
			Main.InputSpeedPlayer2 = Main.textFieldSpeedPlayer2.getText();
			Main.LabelSpeedPlayer2.setText(Main.InputSpeedPlayer2);
			Main.LabelSpeedPlayer2.setVisible(true);
		}

		if(e.getSource() == Main.ShootButtonPlayer1) {
			panPlanets.CalculateShot();
			Main.Shoot = true;
			frame.repaint();
		}

		if(e.getSource() == Main.ShootButtonPlayer2) {
			//panPlanets.CalculateShot();
			//Main.Shoot = true;
			//frame.repaint();
		}

		if(e.getSource() == Main.ResetGameButton) {
			panPlanets.CalculatePlanets();
			panPlanets.CalculateShip();
			frame.repaint();
		}
		
	}
}
