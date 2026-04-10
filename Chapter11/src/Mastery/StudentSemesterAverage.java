/*
Program: StudentSemesterAverage.java.java          
Purpose: This Java program is a GUI application that allows users to enter student information and grades, calculates the average, saves the data to a file, and displays saved records.

Author: Usman Elmi, 
School: CHHS
Course: Computer Programming 30
 

*/


package Mastery;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class StudentSemesterAverage {
	private JFrame frame;
	private JTextField stuname, grdlvl, semnum, grd1, grd2, grd3, grd4;
	private static final String FILE_NAME = "Grades.txt";
	private File dataFile = new File(FILE_NAME);

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				StudentSemesterAverage window = new StudentSemesterAverage();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public StudentSemesterAverage() {
		initialize();
	}

	private void initialize() {
		
		DecimalFormat decimalFormatter = new DecimalFormat("0.#");
		NumberFormat percent = NumberFormat.getPercentInstance();
		
		frame = new JFrame("Student Semester Average"); //title added
		frame.setBounds(100, 100, 554, 624);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); //center window
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 240, 255));
		panel.setBounds(0, 0, 548, 574);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(86, 11, 142, 25);
		panel.add(lblNewLabel);
		
		JLabel lblGradeLevel = new JLabel("Grade Level:");
		lblGradeLevel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGradeLevel.setBounds(369, 11, 142, 25);
		panel.add(lblGradeLevel);
		
		JLabel lblSemesterNumber = new JLabel("Semester Number:");
		lblSemesterNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemesterNumber.setBounds(186, 83, 160, 25);
		panel.add(lblSemesterNumber);
		
		JLabel lblGrade = new JLabel("Grade 1:");
		lblGrade.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblGrade.setBounds(10, 151, 142, 25);
		panel.add(lblGrade);
		
		JLabel lblGrade_5 = new JLabel("Grade 2:");
		lblGrade_5.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblGrade_5.setBounds(320, 151, 142, 25);
		panel.add(lblGrade_5);
		
		JLabel lblGrade_1 = new JLabel("Grade 3:");
		lblGrade_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblGrade_1.setBounds(10, 198, 142, 25);
		panel.add(lblGrade_1);
		
		JLabel lblGrade_2 = new JLabel("Grade 4:");
		lblGrade_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblGrade_2.setBounds(320, 198, 142, 25);
		panel.add(lblGrade_2);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAverage.setBounds(10, 259, 87, 25);
		panel.add(lblAverage);
		
		stuname = new JTextField();
		stuname.setToolTipText("Enter student name"); //tool tip
		stuname.setBounds(67, 47, 142, 25);
		panel.add(stuname);
		
		grdlvl = new JTextField();
		grdlvl.setToolTipText("Enter grade level");
		grdlvl.setBounds(336, 47, 142, 25);
		panel.add(grdlvl);
		
		semnum = new JTextField();
		semnum.setToolTipText("Enter semester number");
		semnum.setBounds(86, 115, 366, 25);
		panel.add(semnum);
		
		grd1 = new JTextField();
		grd1.setBounds(67, 151, 100, 25);
		panel.add(grd1);
		
		grd2 = new JTextField();
		grd2.setBounds(378, 152, 100, 25);
		panel.add(grd2);
		
		grd3 = new JTextField();
		grd3.setBounds(378, 199, 100, 25);
		panel.add(grd3);
		
		grd4 = new JTextField();
		grd4.setBounds(67, 199, 100, 25);
		panel.add(grd4);
		
		JLabel avg = new JLabel("");
		avg.setFont(new Font("Segoe UI", Font.BOLD, 14));
		avg.setBounds(84, 259, 100, 25);
		panel.add(avg);
		
		JTextArea dis = new JTextArea();
		dis.setLineWrap(true); //wrap text
		dis.setWrapStyleWord(true);
		dis.setEditable(false);
		dis.setBounds(20, 289, 481, 118);
		panel.add(dis);
		
		Color buttonColor = new Color(100, 149, 237);

		JButton savebtn = new JButton("Save To File");
		savebtn.setBackground(buttonColor);
		savebtn.setBounds(39, 540, 131, 23);
		panel.add(savebtn);
		
		JButton showbtn = new JButton("Show File");
		showbtn.setBackground(buttonColor);
		showbtn.setBounds(326, 540, 152, 23);
		panel.add(showbtn);
		
		
		savebtn.addActionListener(e -> {
			String studentname = stuname.getText().trim();
			String gradelevel = grdlvl.getText().trim();
			String semesternum = semnum.getText().trim();
			String grade1 = grd1.getText().trim();
			String grade2 = grd2.getText().trim();
			String grade3 = grd3.getText().trim();
			String grade4 = grd4.getText().trim();

			if (studentname.isEmpty() || gradelevel.isEmpty() || semesternum.isEmpty() ||
				grade1.isEmpty() || grade2.isEmpty() || grade3.isEmpty() || grade4.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fill all fields first!");
				return; //stops execution
			}

			try {
				double avgGrade = (Double.parseDouble(grade1) + Double.parseDouble(grade2) +
						Double.parseDouble(grade3) + Double.parseDouble(grade4)) / 4;

				avg.setText(decimalFormatter.format(avgGrade) + "%");

				BufferedWriter writeFile = new BufferedWriter(new FileWriter(dataFile, true));
				writeFile.write("Name: " + studentname + " | Avg: " + decimalFormatter.format(avgGrade) + "%");
				writeFile.newLine();
				writeFile.close();

				JOptionPane.showMessageDialog(null, "Saved!");

			} catch (Exception err) {
				JOptionPane.showMessageDialog(null, "Invalid input!");
			}
		});

		
		showbtn.addActionListener(e -> {
			dis.setText("");
			try (BufferedReader readFile = new BufferedReader(new FileReader(dataFile))) {
				String line;
				while ((line = readFile.readLine()) != null) {
					dis.append(line + "\n");
				}
			} catch (Exception err) {
				JOptionPane.showMessageDialog(null, "Error reading file");
			}
		});


	}
	
	
}