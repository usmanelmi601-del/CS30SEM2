package SkillBuilders;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Metriconversion extends JFrame {

    public Metriconversion() {

        setTitle("Metric Conversion");

        // Smaller window
        setSize(360, 160);

        // Center on screen
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 192));
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel lblFormula = new JLabel("Select a conversion");
        lblFormula.setForeground(new Color(0, 0, 160));
        lblFormula.setBackground(new Color(255, 128, 128));
        lblFormula.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblFormula);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setForeground(new Color(128, 128, 255));
        comboBox.setBackground(new Color(64, 128, 128));
        comboBox.setFont(new Font("Arial", Font.PLAIN, 13));
        comboBox.addItem("Inches to Centimeters");
        comboBox.addItem("Feet to Meters");
        comboBox.addItem("Gallons to Liters");
        comboBox.addItem("Pounds to Kilograms");
        panel.add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selection = (String) comboBox.getSelectedItem();

                if (selection.equals("Inches to Centimeters"))
                    lblFormula.setText("1 inch = 2.54 centimeters");
                else if (selection.equals("Feet to Meters"))
                    lblFormula.setText("1 foot = 0.3048 meters");
                else if (selection.equals("Gallons to Liters"))
                    lblFormula.setText("1 gallon = 4.5461 liters");
                else if (selection.equals("Pounds to Kilograms"))
                    lblFormula.setText("1 pound = 0.4536 kilograms");
            }
        });
    }

    public static void main(String[] args) {
        new Metriconversion().setVisible(true);
    }
}