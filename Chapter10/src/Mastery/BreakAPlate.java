package Mastery;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class BreakAPlate {
	/*

	Program: BreakAPlate.java          

	Purpose: Users choose a conversion type from a combo box, and the matching formula appears in a label. 
	Conversions: 1 inch = 2.54 centimeters; 1 foot = 0.3048 meters; 1 gallon = 4.5461 liters; 1 pound = 0.4536 kilograms.

	Author: Usman Elmi, 
	School: CHHS
	Course: Computer Programming 30
	 

	*/

	public class Tester 
	{

	    public static void main(String args[])
	    {
	       
	       
	    }
	}


	
	private JFrame frame;
	private JLabel lblPlates, lblPrize;  // Labels to display plates and prize

	public static void main(String[] args) {
		// Launching the application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BreakAPlate() {
		initialize();
	}

	private void initialize() {
		
		
		ImageIcon imgAllBroken = new ImageIcon("..\\Chapter10\\src\\Mastery\\plates_all_broken.gif");
		ImageIcon imgTwoBroken = new ImageIcon("../Chapter10/src/Mastery/plates_two_broken.gif");
		ImageIcon sticker = new ImageIcon("../Chapter10/src/Mastery/sticker.gif");
		ImageIcon tiger = new ImageIcon("../Chapter10/src/Mastery/tiger_plush.gif");
		
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		// Button to start the game
		JButton btnNewButton = new JButton("Click to Play!");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Dubai", Font.PLAIN, 20));
		btnNewButton.setBounds(130, 201, 160, 35);
		panel.add(btnNewButton);
		
		// Label to display plates
		lblPlates = new JLabel("");
		lblPlates.setBackground(new Color(128, 128, 128));
		lblPlates.setIcon(new ImageIcon(BreakAPlate.class.getResource("/Mastery/plates.gif")));
		lblPlates.setBounds(82, 11, 279, 102);
		panel.add(lblPlates);
		
		
		lblPrize = new JLabel("");
		lblPrize.setBounds(160, 120, 120, 70);
		panel.add(lblPrize);
		
		// Button click action
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Reset to 3 unbroken plates, clear prize
				lblPlates.setIcon(new ImageIcon(BreakAPlate.class.getResource("/Mastery/plates.gif")));
				
				lblPrize.setIcon(null);
				
				// Loading the images
				
				// Random outcomes
				if (Math.random() < 0.5) {
					lblPlates.setIcon(imgTwoBroken);
					lblPrize.setIcon(sticker);
				} else {
					lblPlates.setIcon(imgAllBroken);
					lblPrize.setIcon(tiger);
				}
			}
		});
	}
}
   