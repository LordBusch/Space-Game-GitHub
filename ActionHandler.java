import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
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

			panPlanets.add(Main.ButtonSpeed);
			panPlanets.add(Main.ButtonAngle);
			panPlanets.add(Main.LabelAngle);
			panPlanets.add(Main.LabelSpeed);
			panPlanets.add(Main.textFieldSpeed);
			panPlanets.add(Main.textFieldAngle);
			panPlanets.add(Main.ResetGameButton);
			panPlanets.add(Main.ShootButton);
			
			panPlanets.CalculateShip();
			panPlanets.CalculatePlanets();
			

			
		
		 
			// Add panel new panel object to main frame and remove former obejct
			frame.remove(Main.pan1);
			frame.add(panPlanets);
			frame.setVisible(true);
				
			
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

		if(e.getSource() == Main.ResetGameButton) {
			panPlanets.CalculatePlanets();
			panPlanets.CalculateShip();
			frame.repaint();
		}

		if(e.getSource() == Main.ShootButton) {
			panPlanets.CalculateShot();
			Main.Shoot = true;
			frame.repaint();
		}
		
	}
}
