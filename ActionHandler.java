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
		
		GameModes GameModePanel = new GameModes();
		SecondGameMode panSecondGameMode = new SecondGameMode();
		Calculate panPlanets = new Calculate();
		JFrame frame = Main.frame;
		KeyHandler khandler = new KeyHandler();
		
		if(e.getSource() == Main.GameModeButton) {
			GameModes.GameModesActive = true;

			GameModePanel.add(Main.FirstGameModeButton);
			GameModePanel.add(Main.SecondGameModeButton);
			GameModePanel.addKeyListener(khandler);

			frame.remove(Main.pan1);
			frame.add(GameModePanel);
			frame.setVisible(true);
			frame.repaint();
		}
		
		if(e.getSource() == Main.FirstGameModeButton) {
			GameModes.GameModesActive = false;
			GameModePanel.remove(Main.FirstGameModeButton);
			GameModePanel.remove(Main.SecondGameModeButton);
			Main.FirstGameModeButton.setVisible(false);
			Main.SecondGameModeButton.setVisible(false);
			frame.remove(GameModePanel);
			GameModePanel.setVisible(false);
			//frame.removeAll();
			frame.add(Main.StartGamePanel);
			frame.setVisible(true);
			frame.repaint();
		}

		if(e.getSource() == Main.SecondGameModeButton) {
			Main.GameActive = true;
			GameModes.GameModesActive = false;

			GameModePanel.remove(Main.FirstGameModeButton);
			GameModePanel.remove(Main.SecondGameModeButton);
			Main.FirstGameModeButton.setVisible(false);
			Main.SecondGameModeButton.setVisible(false);
			frame.remove(GameModePanel);
			GameModePanel.setVisible(false);
			panSecondGameMode.add(Main.MainMenuButton);
			frame.add(panSecondGameMode);
			frame.setVisible(true);
			frame.repaint();
		}

		if(e.getSource() == Main.CloseWindowButton) {
			System.exit(0);
		}

		if(e.getSource() == Main.FirstStartButton) {
			
			if (Main.StarWarsMode | Main.NormalMode) {
				System.out.println("Starting");
				Main.Start = true;

				Main.activeplayer = 0;
				Main.KillCount1 = 0;
				Main.KillCount2 = 0;
				Main.KillCounterPlayer1.setText("0");
				Main.KillCounterPlayer2.setText("0");
				Calculate.numberOfPlanets = 0;

				Main.LabelAnglePlayer1.setText("");
				Main.InputAnglePlayer1 = "0";
				Main.LabelAnglePlayer2.setText("");
				Main.InputAnglePlayer1 = "0";
				Main.LabelSpeedPlayer1.setText("");
				Main.InputSpeedPlayer1 = "0";
				Main.LabelSpeedPlayer2.setText("");
				Main.InputSpeedPlayer1 = "0";

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
				panPlanets.add(Main.KillCounterPlayer1);
				panPlanets.add(Main.KillCounterPlayer2);
				panPlanets.add(Main.ResetGameButton);
				panPlanets.add(Main.MainMenuButton);
				
				System.out.println("DEBUG - Before calling calc methods");
				panPlanets.CalculateShip();
				panPlanets.CalculatePlanets();
				panPlanets.CalculateBlackHole();
				System.out.println("DEBUG - After calling calc methods");
		 
				// Add panel new panel object to main frame and remove former obejct
				frame.remove(Main.StartGamePanel);
				frame.add(panPlanets);
				frame.setVisible(true);
				frame.repaint();
				System.out.println("DEBUG - After repaint");
			}
			
		}
		

		if(e.getSource() == Main.MainMenuButton) {
			Main.GameActive = false;
			Main.FirstGameModeButton.setVisible(true);
			Main.SecondGameModeButton.setVisible(true);

			frame.remove(panPlanets);
			panPlanets.setVisible(false);
			frame.getContentPane().removeAll();

			SecondGameMode.xposship = Main.PANEL_SIZE_X / 2 - 25;
			SecondGameMode.yposship = Main.PANEL_SIZE_Y - 50;

			frame.add(Main.pan1);
			Main.pan1.setVisible(true);
			frame.repaint();
			frame.setVisible(true);
		}


        if(e.getSource() == Main.AngleButtonPlayer1) {
			Main.InputAnglePlayer1 = Main.textFieldAnglePlayer1.getText();
			Main.LabelAnglePlayer1.setText(Main.InputAnglePlayer1);
			Main.LabelAnglePlayer1.setVisible(true);
            
		}

		if(e.getSource() == Main.AngleButtonPlayer2) {
			Main.InputAnglePlayer2 = Main.textFieldAnglePlayer2.getText();
			Main.LabelAnglePlayer2.setText(Main.InputAnglePlayer2);
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
			if(Main.activeplayer == 0) {
				panPlanets.CalculateShot();
				Main.Shoot = true;
				frame.repaint();
			}
		}

		if(e.getSource() == Main.ShootButtonPlayer2) {
			if(Main.activeplayer == 1) {
				panPlanets.CalculateShot();
				Main.Shoot = true;
				frame.repaint();
			}
		}

		if(e.getSource() == Main.ResetGameButton) {
			Main.Start = true;
			panPlanets.CalculatePlanets();
			panPlanets.CalculateShip();
			//panPlanets.CalculateBlackHole();
			frame.repaint();
		}

		if(e.getSource() == Main.StarWarsModeButton) {
			Main.StarWarsMode = true;
			Main.NormalMode = false;
			Main.StarWarsModeLabel.setText("Activated");
			Main.NormalModeLabel.setText("");
		}

		if(e.getSource() == Main.NormalModeButton) {
			Main.NormalMode = true;
			Main.StarWarsMode = false;
			Main.NormalModeLabel.setText("Activated");
			Main.StarWarsModeLabel.setText("");
		}
		
		new KeyHandler();
	}

}
