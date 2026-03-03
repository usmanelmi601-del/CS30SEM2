package Chapter10.demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Demo7 {

	private JFrame frame;
	private JTextField FN;
	private JTextField LN;
	private JTextField FN1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo7 window = new Demo7();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo7() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		
		ImageIcon cr = new ImageIcon("../Chapter10/src/Chapter10/demo/CrescentHeights.png");
		ImageIcon cw = new ImageIcon("../Chapter10/src/Chapter10/demo/Pierson.png");
		ImageIcon ch = new ImageIcon("../Chapter10/src/Chapter10/demo/Churchil.png");
		ImageIcon wc = new ImageIcon("../Chapter10/src/Chapter10/demo/wchs.png");
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 568, 497);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		LN = new JTextField();
		LN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				LN.setText(" ");
			}
		});
		LN.setForeground(Color.LIGHT_GRAY);
		LN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		LN.setText("Last Name");
		LN.setColumns(10);
		LN.setBounds(227, 56, 162, 32);
		panel.add(LN);
		
		JComboBox gradeL = new JComboBox();
		gradeL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gradeL.setModel(new DefaultComboBoxModel(new String[] {"Select Grade:", "10", "11", "12"}));
		gradeL.setBounds(40, 116, 176, 39);
		panel.add(gradeL);
		
		JComboBox schools = new JComboBox();
		schools.setModel(new DefaultComboBoxModel(new String[] {"Select School:", "Cresent Heights", "Western", "Churchill", "Pearson"}));
		schools.setFont(new Font("Tahoma", Font.PLAIN, 15));
		schools.setBounds(242, 116, 168, 39);
		panel.add(schools);
		
		JTextArea Disp = new JTextArea();
		Disp.setBounds(40, 192, 370, 117);
		panel.add(Disp);
		
		
		
		JLabel imgA = new JLabel("");
		imgA.setBounds(74, 319, 315, 148);
		panel.add(imgA);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String grade =  "";
				String school = "";
				String FirstN = FN1.getText();
				String LastN = LN.getText();
				
				if(gradeL.getSelectedItem().equals("10"))
				{
					grade = "10";
				}
				else if(gradeL.getSelectedItem().equals("11"))
				{
					grade = "11";
				}
				else
				{
					grade = "12";
				}
				
				if(schools.getSelectedItem().equals("Cresent Heights"))
				{
					school = "Crescent Heights";
					imgA.setIcon(cr);
					
				}
				else if(schools.getSelectedItem().equals("Western"))
				{
					school = "Western";
					imgA.setIcon(wc);
				}
				else if(schools.getSelectedItem().equals("Churchill"))
				{
					school = "Churchill";
					imgA.setIcon(ch);
				}
				else
				{
					school = "Pearson";
					imgA.setIcon(cw);
				}
				
				Disp.setText(FirstN + " "+
							 LastN + " "+
							 grade + " "+
							 school );
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(431, 38, 93, 271);
		panel.add(btnNewButton);
		
		FN1 = new JTextField();
		FN1.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				if(FN1.getText().equals("First Name"))
					FN1.setText("");
			}
		});
		FN1.setText("First Name");
		FN1.setForeground(Color.LIGHT_GRAY);
		FN1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FN1.setColumns(10);
		FN1.setBounds(50, 56, 162, 32);
		panel.add(FN1);
		
		
		
		
	}
}