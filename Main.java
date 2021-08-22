import java.awt.*;
import javax.swing.*;

// ABCDEFG


public class Main {
	private static final int BUTTON_HEIGHT = 50;
	public static final int PANEL_SIZE_X = 1920;
	public static final int PANEL_SIZE_Y = 1080;
	public static final int MAX_PLANET_RADIUS = 100;
	public static final int MIN_PLANET_RADIUS = 20;
	public static String InputCountPlanets;
	public static boolean Shoot = false;
	public static boolean Start = false;
    public static String InputAnglePlayer1;
	public static String InputAnglePlayer2;
    public static String InputSpeedPlayer1;
	public static String InputSpeedPlayer2;
	public static String TextForLabelAnglePlayer1;
	public static String TextForLabelSpeedPlayer1;
	public static JButton button0;
	public static JButton ResetGameButton;
	public static JButton ShootButtonPlayer1;
	public static JButton ShootButtonPlayer2;
	public static JLabel labPlanets;
	public static JPanel pan1;
	public static JFrame frame;
    public static JTextField textFieldAnglePlayer1;
	public static JTextField textFieldAnglePlayer2;
    public static JTextField textFieldSpeedPlayer1;
	public static JTextField textFieldSpeedPlayer2;
	public static JTextField textFieldCountPlanets;
    public static JButton AngleButtonPlayer1;
	public static JButton AngleButtonPlayer2;
    public static JButton SpeedButtonPlayer1;
	public static JButton SpeedButtonPlayer2;
	public static JLabel LabelAnglePlayer1;
	public static JLabel LabelAnglePlayer2;
	public static JLabel LabelSpeedPlayer1;
	public static JLabel LabelSpeedPlayer2;
	public static JLabel LabelCountPlanets;
	public static ActionHandler handler;
	
	
	
	public Main(){
		gui();
		
	}
	
	
	
	
	
	public void gui() {
		
		
		
		
		
		frame = new JFrame ("Space Game");
		ImageIcon image = new ImageIcon("Rakete Icon.png");
		frame.setIconImage(image.getImage());
		frame.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		//frame.setLocationRelativeTo(null);
		frame.requestFocus();
		frame.setBackground(Color.BLACK);
		frame.setIconImage(image.getImage());
		frame.setExtendedState(frame.MAXIMIZED_BOTH);


		
		
		// Action handler
		handler = new ActionHandler();
		
		// Create button0
		button0 = new JButton("Start");
		button0.setBounds(100, 100, 100, BUTTON_HEIGHT);
		button0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button0.addActionListener(handler);
		button0.setVisible(true);
		button0.setIcon(new ImageIcon("Frage1V3.png"));
		button0.setPressedIcon(new ImageIcon("Frage1V3Pressed.png"));
		button0.setRolloverIcon(new ImageIcon("Frage1V3Rollover.png"));
		

		ResetGameButton = new JButton("Reset Game");
		ResetGameButton.setBounds(PANEL_SIZE_X / 2 - 50, 0, 100, BUTTON_HEIGHT);
		ResetGameButton.addActionListener(handler);

/*
		AngleButtonPlayer1 = new JButton("Angle");
		AngleButtonPlayer1.setBounds(70, 0, 70, 30);
		AngleButtonPlayer1.addActionListener(handler);
		AngleButtonPlayer1.setVisible(true);
*/		 

		/*
		// Create Button for Angle
		Main.AngleButtonPlayer1 = new JButton("Angle");
		Main.AngleButtonPlayer1.setBounds(70, 0, 70, 30);
		Main.AngleButtonPlayer1.addActionListener(handler);

        // Create Button for Speed
		Main.SpeedButtonPlayer1 = new JButton("Speed");
		Main.SpeedButtonPlayer1.setBounds(70, 30, 70, 30);
		Main.SpeedButtonPlayer1.addActionListener(handler);
*/

		//menu player 1
		ShootButtonPlayer1 = new JButton("Shoot");
		ShootButtonPlayer1.setBounds(0, 60, 100, BUTTON_HEIGHT);
		ShootButtonPlayer1.addActionListener(handler);

		textFieldAnglePlayer1 = new JTextField();
		textFieldAnglePlayer1.setBounds(0, 0, 70, 30);
		

		textFieldSpeedPlayer1 = new JTextField();
		textFieldSpeedPlayer1.setBounds(0, 30, 70, 30);
		

		LabelAnglePlayer1 = new JLabel(TextForLabelAnglePlayer1);
		LabelAnglePlayer1.setBounds(140, 0, 70, 30);
		LabelAnglePlayer1.setVisible(false);

		LabelSpeedPlayer1 = new JLabel(TextForLabelSpeedPlayer1);
		LabelSpeedPlayer1.setBounds(140, 30, 70, 30);
		LabelSpeedPlayer1.setVisible(false);

		SpeedButtonPlayer1 = new JButton("Speed");
		SpeedButtonPlayer1.setBounds(70, 30, 70, 30);
		SpeedButtonPlayer1.addActionListener(handler);

		AngleButtonPlayer1 = new JButton("Angle");
		AngleButtonPlayer1.setBounds(70, 0, 70, 30);
		AngleButtonPlayer1.addActionListener(handler);
		 


		//menu player 2
		ShootButtonPlayer2 = new JButton("Shoot");
		ShootButtonPlayer2.setBounds(PANEL_SIZE_X - 100, 60, 100, BUTTON_HEIGHT);
		ShootButtonPlayer2.addActionListener(handler);

		textFieldAnglePlayer2 = new JTextField();
		textFieldAnglePlayer2.setBounds(PANEL_SIZE_X - 210, 0, 70, 30);
		

		textFieldSpeedPlayer2 = new JTextField();
		textFieldSpeedPlayer2.setBounds(PANEL_SIZE_X - 210, 30, 70, 30);
		

		LabelAnglePlayer2 = new JLabel(TextForLabelAnglePlayer1);
		LabelAnglePlayer2.setBounds(PANEL_SIZE_X - 70, 0, 70, 30);
		LabelAnglePlayer2.setVisible(false);

		LabelSpeedPlayer2 = new JLabel(TextForLabelSpeedPlayer1);
		LabelSpeedPlayer2.setBounds(PANEL_SIZE_X - 70, 30, 70, 30);
		LabelSpeedPlayer2.setVisible(false);

		AngleButtonPlayer2 = new JButton("Angle");
		AngleButtonPlayer2.setBounds(PANEL_SIZE_X - 140, 0, 70, 30);
		AngleButtonPlayer2.addActionListener(handler);

		SpeedButtonPlayer2 = new JButton("Speed");
		SpeedButtonPlayer2.setBounds(PANEL_SIZE_X - 140, 30, 70, 30);
		SpeedButtonPlayer2.addActionListener(handler);



		textFieldCountPlanets = new JTextField();
		textFieldCountPlanets.setBounds(200, 100, 70, 30);

		LabelCountPlanets = new JLabel("Planets");
		LabelCountPlanets.setBounds(200, 130, 70, 20);

		
		// Create main panel
		pan1 = new JPanel();
		pan1.setBackground(Color.gray);
		pan1.setLayout(null); // set to x,y coordinates (0,0) is upper left
		
		
		pan1.add(button0);
		pan1.add(textFieldCountPlanets);
		pan1.add(LabelCountPlanets);
		
		// Add main panel to frame and make visible
		frame.add(pan1);
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		
		new Main();
		
	}

}