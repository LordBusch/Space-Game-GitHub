import java.awt.*;
import javax.swing.*;
import java.io.*;

// ABCDEFG


public class Main {
	private static final int BUTTON_HEIGHT = 50;
	public static final int PANEL_SIZE_X = 1920;
	public static final int PANEL_SIZE_Y = 1080;
	public static final int MAX_PLANET_RADIUS = 100;
    public static String InputAngle;
    public static String InputSpeed;
	public static String TextForLabelAngle = "Hallo";
	public static String TextForLabelSpeed = "Hallo";
	public static JButton button2;
	public static JButton button1;
	public static JButton button0;
	public static JLabel labPlanets;
	public static JPanel pan1;
	public static JPanel panPlanets;
	public static JFrame frame;
    public static JTextField textFieldAngle;
    public static JTextField textFieldSpeed;
    public static JButton ButtonAngle;
    public static JButton ButtonSpeed;
	public static JLabel LabelAngle;
	public static JLabel LabelSpeed;
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
		
		// Create button1
		button1 = new JButton("Button 2");
		button1.setBounds(100, 200, 100, BUTTON_HEIGHT);
		button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button1.addActionListener(handler);
		button1.setVisible(true);
	
		
		// Create button2
		button2 = new JButton("Button 3");
		button2.setBounds(100, 300, 100, BUTTON_HEIGHT);
		button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		button2.addActionListener(handler);
		button2.setVisible(true);
/*
		ButtonAngle = new JButton("Angle");
		ButtonAngle.setBounds(70, 0, 70, 30);
		ButtonAngle.addActionListener(handler);
		ButtonAngle.setVisible(true);
*/		 

		/*
		// Create Button for Angle
		Main.ButtonAngle = new JButton("Angle");
		Main.ButtonAngle.setBounds(70, 0, 70, 30);
		Main.ButtonAngle.addActionListener(handler);

        // Create Button for Speed
		Main.ButtonSpeed = new JButton("Speed");
		Main.ButtonSpeed.setBounds(70, 30, 70, 30);
		Main.ButtonSpeed.addActionListener(handler);
*/
		Main.textFieldAngle = new JTextField();
		Main.textFieldAngle.setBounds(0, 0, 70, 30);
		

		Main.textFieldSpeed = new JTextField();
		Main.textFieldSpeed.setBounds(0, 30, 70, 30);
		

		LabelAngle = new JLabel(TextForLabelAngle);
		LabelAngle.setBounds(140, 0, 70, 30);
		LabelAngle.setVisible(true);

		LabelSpeed = new JLabel(TextForLabelSpeed);
		LabelSpeed.setBounds(140, 30, 70, 30);
		LabelSpeed.setVisible(true);

		Main.ButtonSpeed = new JButton("Speed");
		Main.ButtonSpeed.setBounds(70, 30, 70, 30);
		Main.ButtonSpeed.addActionListener(handler);

		Main.ButtonAngle = new JButton("Angle");
		Main.ButtonAngle.setBounds(70, 0, 70, 30);
		Main.ButtonAngle.addActionListener(handler);
		 
		

		
		// Create main panel
		pan1 = new JPanel();
		pan1.setBackground(Color.gray); // gray background
		pan1.setLayout(null); // set to x,y coordinates (0,0) is upper left
		
		// Add 3 buttons to main panel
		pan1.add(button0);
		pan1.add(button1);
		pan1.add(button2);
		
//        pan1.add(ButtonAngle);

        
		
		// Add main panel to frame and make visible
		frame.add(pan1);
		frame.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		
		new Main();
		
	}

}